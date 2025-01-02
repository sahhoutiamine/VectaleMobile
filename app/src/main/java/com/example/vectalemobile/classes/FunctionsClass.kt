package com.example.vectalemobile.classes


import com.example.vectalemobile.classes.data.listCards
import com.example.vectalemobile.classes.data.listPacks
import com.example.vectalemobile.classes.data.listUsers
import com.example.vectalemobile.classes.info.Card
import com.example.vectalemobile.classes.info.Pack
import com.example.vectalemobile.classes.info.PackType
import com.example.vectalemobile.classes.info.User
import kotlin.random.Random

class FunctionsClass {


    fun findUser(email : String, password : String):Int{
        for ( user in listUsers){
            if (user.userEmail == email && user.userPassword == password){
                return user.id
            }
        }
        return -1
    }
}