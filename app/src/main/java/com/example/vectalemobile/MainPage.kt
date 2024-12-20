package com.example.vectalemobile

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.vectalemobile.classes.data.Lists

class MainPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_page_activity)

        var usr = Lists().listUsers[0]

        var first_name = findViewById<TextView>(R.id.first_name)
        val last_name = findViewById<TextView>(R.id.last_name)
        val codeCard = findViewById<TextView>(R.id.code_number)
        val imgUser = findViewById<ImageView>(R.id.user_icon)
    }
}