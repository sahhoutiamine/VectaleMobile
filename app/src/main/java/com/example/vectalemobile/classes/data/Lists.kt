package com.example.vectalemobile.classes.data

import com.example.vectalemobile.classes.info.Card
import com.example.vectalemobile.classes.info.Pack
import com.example.vectalemobile.classes.info.PackType
import com.example.vectalemobile.classes.info.User

val listUsers = mutableListOf<User>(
    User(0,"a","a","a","a","a","a","a","amine@gmail.com","sahhouti")
)
val listPacks = mutableListOf<Pack>(Pack("123456789999", 0 , PackType.Tourist))
val listCards = mutableListOf<Card>(Card(0 , listPacks[0].code ,true))