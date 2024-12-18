package com.example.vectalemobile.classes.info.Payment

import android.media.Image
import java.util.Date

class PaymentCard
    (
    idPayment : Int,
    datePayment : Date,
    idCard : Int,
    val img : Image,
    mastercard : String,
    cvv : String,
    enddate : String
):Payment(idPayment , datePayment , idCard){
}