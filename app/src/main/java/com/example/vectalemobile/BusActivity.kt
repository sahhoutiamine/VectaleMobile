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
            Bus("101", "Central - Station"),
            Bus("102", "West - Station"),
            Bus("102", "West - Station"),
            Bus("102", "West - Station"),
            Bus("102", "West - Station"),
            Bus("102", "West - Station"),
            Bus("102", "West - Station"),
            Bus("102", "West - Station"),
            Bus("102", "West - Station"),
            Bus("102", "West - Station"),
            Bus("102", "West - Station"),
            Bus("102", "West - Station")
        )

        val busListView = findViewById<ListView>(R.id.busListView)
        val adapter = BusAdapter(this, busList)
        busListView.adapter = adapter

        val vectaleLogo = findViewById<ImageView>(R.id.imageView4)



        vectaleLogo.setOnClickListener {
            val intent = Intent(this, NavFrActivity::class.java)
            startActivity(intent)
        }
    }

}
