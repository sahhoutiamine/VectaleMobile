package com.example.vectalemobile

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        Handler(Looper.getMainLooper()).postDelayed(
            {
                val intent = Intent(this , BusActivity::class.java)
                startActivity(intent)
                finish()
            },3000
        )
    }
    }

