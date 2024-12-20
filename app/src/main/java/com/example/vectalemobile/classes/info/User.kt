package com.example.vectalemobile.classes.info

class User(
    val id: Int,
    val nom: String,
    val prenom: String,
    val tel: String,
    val dateNaissance: String,
    val adresse: String,
    val cni: String,
    val cne: String,
    var userEmail: String,
    var userPassword: String
) {

    fun setEmail(newEmail: String) {
        if (isValid(newEmail, "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            userEmail = newEmail
        } else {
            throw IllegalArgumentException("email form is incorrect")
        }
    }

    fun setPassword(newPassword: String) {
        if (newPassword.length >= 8) {
            userPassword = newPassword
        } else {
            throw IllegalArgumentException("password is too low")
        }
    }

    companion object {
        fun isValid(input: String, regex: String): Boolean {
            return input.matches(Regex(regex))
        }
    }
}