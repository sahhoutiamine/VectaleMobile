package com.example.vectalemobile

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.vectalemobile.classes.data.createdUserId
import com.example.vectalemobile.classes.data.listCards
import com.example.vectalemobile.classes.data.listPacks
import com.example.vectalemobile.classes.data.listUsers
import java.time.LocalDateTime

class CardInfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.card_info_activity)



        for (user in listUsers){
            if (user.id == createdUserId){
                val nom = findViewById<TextView>(R.id.nom)
                val prenom = findViewById<TextView>(R.id.Prenom)
                val email = findViewById<TextView>(R.id.EmailInfo)
                val cni = findViewById<TextView>(R.id.cniInfo)
                val cne = findViewById<TextView>(R.id.CNEInfo)
                val birthday = findViewById<TextView>(R.id.birthday)
                val code = findViewById<TextView>(R.id.code)


                nom.text = user.nom
                prenom.text = user.prenom
                email.text = user.userEmail
                cni.text = user.cni
                cne.text = user.cne
                birthday.text = user.dateNaissance
                for ( pack in listPacks){
                    if (pack.idUser == user.id){
                        code.text = pack.code



                        }


                }


                }
            }
        }


    }

