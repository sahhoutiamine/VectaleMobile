package com.example.vectalemobile

import com.example.vectalemobile.bank.BankAdapter
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.vectalemobile.bank.Bank

class RibActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    private lateinit var adapter: BankAdapter
    private lateinit var bankList: MutableList<Bank>
    private val imagePicker = registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
        uri?.let {
            selectedPosition?.let { position ->
                adapter.updateItemWithImage(position, it)
            }
        }
    }
    private var selectedPosition: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.rib_activity)

        val bankList = mutableListOf(
            Bank("Bank of America", "1234567812345678"),
            Bank("Chase Bank", "2345678923456789"),
            Bank("Wells Fargo", "3456789034567890"),
            Bank("Citibank", "4567890145678901"),
            Bank("Capital One", "5678901256789012"),
            Bank("US Bank", "6789012367890123"),
            Bank("PNC Bank", "7890123478901234"),
            Bank("TD Bank", "8901234589012345"),
            Bank("BB&T (now Truist)", "9012345690123456"),
            Bank("SunTrust (now Truist)", "0123456701234567")
        )


        adapter = BankAdapter(this, bankList) { position, _ ->
            selectedPosition = position
            imagePicker.launch("image/*")
        }

        recyclerView = findViewById(R.id.banksRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }
}
