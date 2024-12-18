package com.example.vectalemobile.bus

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.vectalemobile.R

class BusAdapter(
    private val context: Context,
    private val dataList: List<DataBus>
) : BaseAdapter() {

    override fun getCount(): Int = dataList.size

    override fun getItem(position: Int): Any = dataList[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.bus_stations_item, parent, false)

        val busNumber = view.findViewById<TextView>(R.id.busNumber)
        val busStation = view.findViewById<TextView>(R.id.busStation)

        val dataBus = getItem(position) as DataBus
        busNumber.text = dataBus.numberBus
        busStation.text = dataBus.busStation

        return view
    }
}