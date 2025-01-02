package com.example.vectalemobile.classes.info

import java.sql.Date
import java.util.Calendar

class Pack(
    val code: String,
    val idUser: Int,
    val packType: PackType,
    val createDate: Date,
    val endDate: Date
) {
    constructor(code: String, idUser: Int, packType: PackType) : this(
        code,
        idUser,
        packType,
        Date(System.currentTimeMillis()),
        calculateEndDate()
    )

    companion object {

        private fun calculateEndDate(): Date {
            val calendar = Calendar.getInstance()
            calendar.time = java.util.Date()
            calendar.add(Calendar.YEAR, 1)
            return Date(calendar.time.time)
        }
    }
}
