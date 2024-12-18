package com.example.vectalemobile.classes

import com.example.vectalemobile.classes.data.Lists
import com.example.vectalemobile.classes.info.Card
import com.example.vectalemobile.classes.info.Pack
import kotlin.random.Random

class FunctionsClass {
//    fun addUsers( user: User){
//        Lists().listUsers.add(user)
//        val Pack = Pack(generateRandomData() , user.id ,)
//        addAbonmont(Abon)
//    }
    fun addPack(pack : Pack){
        Lists().listPacks.add(pack)
        val card = Card(Lists().listCards.size , pack.code , false)
        addCard(card)
    }
    fun addCard(card: Card){
        Lists().listCards.add(card)
    }
    fun generateRandomData(): String {
        val randomChar = ('A'..'Z').random()
        val randomIntegers = (1..9).joinToString("") { Random.nextInt(0, 10).toString() }
        return "$randomChar$randomIntegers"
    }
    fun findUser(email : String, password : String):Int{
        for ( user in Lists().listUsers){
            if (user.userEmail == email && user.userPassword == password){
                return user.id
            }
        }
        return -1
    }
}