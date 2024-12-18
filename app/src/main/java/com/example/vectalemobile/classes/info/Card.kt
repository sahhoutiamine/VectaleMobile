package com.example.vectalemobile.classes.info

import com.example.vectalemobile.classes.info.Payment.PaymentRib
import java.util.Date

class Card(
    val id: Int,
    val code: String,
    var disponible: Boolean
) {
    val listPayments = mutableListOf<PaymentRib>()
    var active: Boolean = false
    var check = false
    fun isActive(){
        val thisDate = Date()

        if (check){
            active = true
        }
    }
}