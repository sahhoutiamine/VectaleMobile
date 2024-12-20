package com.example.vectalemobile

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.vectalemobile.classes.data.Lists
import java.time.LocalDateTime

class MainPage : AppCompatActivity() {
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_page_activity)

        var usr = Lists().listUsers[0]

        var first_name = findViewById<TextView>(R.id.first_name)
        val last_name = findViewById<TextView>(R.id.last_name)
        val codeCard = findViewById<TextView>(R.id.code_number)
        val imgUser = findViewById<ImageView>(R.id.user_icon)
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)

        first_name.text = usr.nom
        last_name.text = usr.prenom
        for ( i in Lists().listPacks){
            if (i.idUser == usr.id){
                codeCard.text = i.code
                for (j in Lists().listCards){
                    Toast.makeText(this,j.code,Toast.LENGTH_SHORT).show()
                    if (j.active && j.code == i.code){
                        progressBar.progress = LocalDateTime.now().dayOfMonth
                    }

            }
        }


    }

}
    }