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
            Bus("1", "New York - Port Authority"),
            Bus("2", "Boston - South Station"),
            Bus("3", "Washington, DC - Union Station"),
            Bus("4", "Philadelphia - Greyhound Terminal"),
            Bus("5", "Chicago - Greyhound Station"),
            Bus("6", "Atlanta - Civic Center MARTA"),
            Bus("7", "Los Angeles - Union Station"),
            Bus("8", "San Francisco - Salesforce Transit"),
            Bus("9", "Seattle - Greyhound Station"),
            Bus("10", "Miami - Intermodal Center")
        )


        val busListView = findViewById<ListView>(R.id.busListView)
        val adapter = BusAdapter(this, busList)
        busListView.adapter = adapter

        val vectaleLogo = findViewById<ImageView>(R.id.imageView4)



        busListView.setOnItemClickListener { _, _, position, _ ->
            val selectedStation = busList[position].busStation


            val intent = Intent(this, BusDetailActivity::class.java).apply {
                putExtra("busStationName", selectedStation)
            }
            startActivity(intent)
        }

        vectaleLogo.setOnClickListener {
            val intent = Intent(this, NavFrActivity::class.java)
            startActivity(intent)
        }
    }

}
