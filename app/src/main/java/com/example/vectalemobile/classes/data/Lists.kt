package com.example.vectalemobile.classes.data

import com.example.vectalemobile.R
import com.example.vectalemobile.classes.FunctionsClass
import com.example.vectalemobile.classes.info.Card
import com.example.vectalemobile.classes.info.Pack
import com.example.vectalemobile.classes.info.PackType
import com.example.vectalemobile.classes.info.User

class Lists {

    val listUsers = mutableListOf<User>(User(0,"a","a","a","a",
        "a","a","a","amine@gmail.com","sahhouti", R.drawable.id_card_ic))
    var cc ="aaa"
    val listPacks = mutableListOf<Pack>(Pack(cc, 0 , PackType.Vip))
    val listCards = mutableListOf<Card>(Card(0 , listPacks[0].code ,true))
}