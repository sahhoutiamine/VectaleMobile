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

        bankList = mutableListOf(
            Bank("Bank 1", "1234569876545678"),
            Bank("Bank 2", "9876549876787654")
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
