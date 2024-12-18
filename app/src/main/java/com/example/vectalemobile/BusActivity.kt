package com.example.vectalemobile

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.vectalemobile.bus.BusAdapter
import com.example.vectalemobile.bus.DataBus

class BusActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bus_activity)


        val busList = listOf(
            DataBus("101", "Central - Station"),
            DataBus("102", "West - Station"),
            DataBus("102", "West - Station"),
            DataBus("102", "West - Station"),
            DataBus("102", "West - Station"),
            DataBus("102", "West - Station"),
            DataBus("102", "West - Station"),
            DataBus("102", "West - Station"),
            DataBus("102", "West - Station"),
            DataBus("102", "West - Station"),
            DataBus("102", "West - Station"),
            DataBus("102", "West - Station"),
            DataBus("102", "West - Station"),
            DataBus("103", "North - Station")
        )

        val listView = findViewById<ListView>(R.id.busListView)
        val adapter = BusAdapter(this, busList)
        listView.adapter = adapter
        var vectaleLogo = findViewById<ImageView>(R.id.imageView4)
        vectaleLogo.setOnClickListener {
            val intent = Intent(this, NavFrActivity::class.java)
            startActivity(intent)
        }
    }

}
