package com.example.vectalemobile

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainPage : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_page_activity)


        var switchToRib = findViewById<Button>(R.id.switchToRib)
        var vectaleLogoMain = findViewById<ImageView>(R.id.vectaleLogoMain)

        vectaleLogoMain.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.vectalia.ma/safi/presentation"))
            startActivity(intent)
        }

        switchToRib.setOnClickListener {
            val intent = Intent(this, RibActivity::class.java)
            startActivity(intent)
        }
    }
}