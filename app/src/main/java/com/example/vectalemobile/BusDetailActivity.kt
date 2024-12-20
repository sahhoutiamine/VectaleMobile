package com.example.vectalemobile


import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class BusDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bus_detail)

        val titleTextView: TextView = findViewById(R.id.titleTextView)
        val detailListView: ListView = findViewById(R.id.detailListView)


        val busStationName = intent.getStringExtra("busStationName")
        titleTextView.text = busStationName


        val stationDetails = listOf("Stop 1", "Stop 2", "Stop 3")
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, stationDetails)
        detailListView.adapter = adapter
    }
}
