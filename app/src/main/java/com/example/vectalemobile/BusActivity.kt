package com.example.vectalemobile

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.vectalemobile.bus.BusAdapter
import com.example.vectalemobile.bus.Bus

class BusActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bus_activity)

        val busList = listOf(
            Bus("1", "New York - Port Authority", listOf("Times Square", "Grand Central", "Wall Street")),
            Bus("2", "Boston - South Station", listOf("Harvard Square", "Fenway Park", "Downtown Crossing")),
            Bus("3", "Washington, DC - Union Station", listOf("Capitol Hill", "National Mall", "Georgetown")),
            Bus("4", "Philadelphia - Greyhound Terminal", listOf("Liberty Bell", "Independence Hall", "Reading Terminal Market")),
            Bus("5", "Chicago - Greyhound Station", listOf("Millennium Park", "Navy Pier", "Wrigley Field")),
            Bus("6", "Atlanta - Civic Center MARTA", listOf("Centennial Park", "Midtown", "Buckhead")),
            Bus("7", "Los Angeles - Union Station", listOf("Hollywood", "Santa Monica", "Downtown LA")),
            Bus("8", "San Francisco - Salesforce Transit", listOf("Union Square", "Chinatown", "Golden Gate Bridge")),
            Bus("9", "Seattle - Greyhound Station", listOf("Pike Place Market", "Space Needle", "Fremont")),
            Bus("10", "Miami - Intermodal Center", listOf("South Beach", "Little Havana", "Wynwood"))
        )

        val busListView = findViewById<ListView>(R.id.busListView)
        val adapter = BusAdapter(this, busList)
        busListView.adapter = adapter

        val vectaleLogo = findViewById<ImageView>(R.id.imageView4)

        busListView.setOnItemClickListener { _, _, position, _ ->
            val selectedBus = busList[position]

            val intent = Intent(this, BusDetailActivity::class.java).apply {
                putExtra("busStationName", selectedBus.busStation)
                putStringArrayListExtra("busStops", ArrayList(selectedBus.stops))
            }
            startActivity(intent)
        }

        vectaleLogo.setOnClickListener {
            val intent = Intent(this, NavFrActivity::class.java)
            startActivity(intent)
        }
    }
}

