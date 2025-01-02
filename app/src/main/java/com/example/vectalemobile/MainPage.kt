package com.example.vectalemobile

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.example.vectalemobile.classes.FunctionsClass
import com.example.vectalemobile.classes.data.createdUserId
import com.example.vectalemobile.classes.data.listCards
import com.example.vectalemobile.classes.data.listPacks
import com.example.vectalemobile.classes.data.listUsers
import com.example.vectalemobile.classes.info.User
import java.time.LocalDateTime

class MainPage : AppCompatActivity() {
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_page_activity)

        for (user in listUsers){
            if (user.id == createdUserId){
                val firstName = findViewById<TextView>(R.id.first_name)
                val lastName = findViewById<TextView>(R.id.last_name)
                val startCard = findViewById<TextView>(R.id.startCard)
                val packType = findViewById<TextView>(R.id.packType)
                val endCard = findViewById<TextView>(R.id.endCard)
                val codeCard = findViewById<TextView>(R.id.code_number)
                val progressBar = findViewById<ProgressBar>(R.id.progressBar)


                firstName.text = user.nom
                lastName.text = user.prenom
                for ( pack in listPacks){
                    if (pack.idUser == user.id){
                        codeCard.text = pack.code
                        for (card in listCards){
                            if (card.active && card.code == pack.code){
                                progressBar.progress = LocalDateTime.now().dayOfMonth
                            }

                        }
                        startCard.text = pack.createDate.toString()
                        endCard.text = pack.endDate.toString()
                        packType.text = pack.packType.toString()

                    }


                }
            }
        }



        var switchCardInfo = findViewById<CardView>(R.id.busCardView)
        switchCardInfo.setOnClickListener {
            val intent = Intent(this, CardInfoActivity::class.java)
            startActivity(intent)
        }

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