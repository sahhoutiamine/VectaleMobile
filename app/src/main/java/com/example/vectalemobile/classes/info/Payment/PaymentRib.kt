package com.example.vectalemobile.classes.info.Payment

import android.media.Image
import java.util.Date

class PaymentRib (
    idPayment : Int,
    datePayment : Date,
    val rib : String,
    idCard : Int,
    val img : Image

):Payment(idPayment , datePayment , idCard)
{
}