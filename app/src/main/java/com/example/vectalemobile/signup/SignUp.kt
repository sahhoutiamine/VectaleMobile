package com.example.vectalemobile.signup

import android.app.AlertDialog
import android.content.Intent
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.vectalemobile.R
import com.example.vectalemobile.classes.data.createdUserId
import com.example.vectalemobile.classes.data.listCards
import com.example.vectalemobile.classes.data.listPacks
import com.example.vectalemobile.classes.data.listUsers
import com.example.vectalemobile.classes.info.Card
import com.example.vectalemobile.classes.info.Pack
import com.example.vectalemobile.classes.info.PackType
import com.example.vectalemobile.classes.info.User
import com.example.vectalemobile.classes.info.User.Companion.isValid
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import kotlin.random.Random

class SignUp : Fragment(R.layout.signup_activity) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val nomField = view.findViewById<TextInputEditText>(R.id.signUpNom)
        val prenomField = view.findViewById<TextInputEditText>(R.id.signUpPrenom)
        val telField = view.findViewById<TextInputEditText>(R.id.signUpTel)
        val emailField = view.findViewById<TextInputEditText>(R.id.signUpEmail)
        val dateNaissanceField = view.findViewById<TextInputEditText>(R.id.signUpDateNaiss)
        val adresseField = view.findViewById<TextInputEditText>(R.id.signUpAdresse)
        val cneField = view.findViewById<TextInputEditText>(R.id.signUpCNE)
        val cniField = view.findViewById<TextInputEditText>(R.id.signUpCIN)
        val passwordField = view.findViewById<EditText>(R.id.signUpPassword)
        val verPasswordField = view.findViewById<EditText>(R.id.signUpPasswordVer)

        val pwVerTextLayout = view.findViewById<TextInputLayout>(R.id.pwVerSignUpText)
        val pwTextLayout = view.findViewById<TextInputLayout>(R.id.pwSignUpText)
        val emailTextLayout = view.findViewById<TextInputLayout>(R.id.emailSignUpText)
        val cniTextLayout = view.findViewById<TextInputLayout>(R.id.cinSignUpText)
        val cneTextLayout = view.findViewById<TextInputLayout>(R.id.cneSignUpText)
        val dateNTextLayout = view.findViewById<TextInputLayout>(R.id.dateNaissSignUpText)
        val telTextLayout = view.findViewById<TextInputLayout>(R.id.telSignUpText)

        val vectaleLogoSU = view.findViewById<ImageView>(R.id.vectaleLogoSignUp)
        var fTypePack = PackType.Student

        val normalPackCard = view.findViewById<View>(R.id.normalPackCard)
        val proPackCard = view.findViewById<View>(R.id.proPackCard)
        val vipPackCard = view.findViewById<View>(R.id.vipPackCard)





        normalPackCard.setOnClickListener {
            fTypePack = PackType.Student
            Toast.makeText(requireContext(), "Normal Pack selected!", Toast.LENGTH_SHORT).show()
        }

        proPackCard.setOnClickListener {
            fTypePack = PackType.Citizen
            Toast.makeText(requireContext(), "Pro Pack selected!", Toast.LENGTH_SHORT).show()
        }

        vipPackCard.setOnClickListener {
            fTypePack = PackType.Tourist
            Toast.makeText(requireContext(), "VIP Pack selected!", Toast.LENGTH_SHORT).show()
        }





        vectaleLogoSU.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.vectalia.ma/safi/presentation"))
            startActivity(intent)
        }

        view.findViewById<Button>(R.id.signupButton).setOnClickListener {
            val nom = nomField.text?.toString().orEmpty()
            val prenom = prenomField.text?.toString().orEmpty()
            val tel = "+212 ${telField.text?.toString().orEmpty()}"
            val email = emailField.text?.toString().orEmpty()
            val dateNaissance = dateNaissanceField.text?.toString().orEmpty()
            val ville = adresseField.text?.toString().orEmpty()
            val cne = cneField.text?.toString().orEmpty()
            val cni = cniField.text?.toString().orEmpty()
            val password = passwordField.text?.toString().orEmpty()
            val verificationPassword = verPasswordField.text?.toString().orEmpty()
            val typePack = fTypePack

            if (password != verificationPassword) {
                Toast.makeText(requireContext(), "The passwords do not match", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (pwVerTextLayout.isErrorEnabled) {
                Toast.makeText(requireContext(), "fill the inputs or Fix the errors first!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val user = User(
                listUsers.size,
                nom,
                prenom,
                tel,
                dateNaissance,
                ville,
                cni,
                cne,
                email,
                password
            )
            listUsers.add(user)


            fun randomNumbers(): String {
                return List(12) { Random.nextInt(0, 10) }.joinToString("") // Generates digits (0-9) and concatenates them
            }

            val pack = Pack(randomNumbers() , user.id ,typePack)

            val card = Card(listCards.size , pack.code , false)


            if (listUsers.add(user)) {
                listPacks.add(pack)
                showSuccessDialog()
                createdUserId=user.id
            }

            if (listPacks.add(pack)) {
                listCards.add(card)

            }


        }

        view.findViewById<TextView>(R.id.switchToLoginButton).setOnClickListener {
            findNavController().navigate(R.id.action_signupFragment_to_loginFragment)
        }

        verPasswordField.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                val password1 = passwordField.text?.toString().orEmpty()
                val password2 = verPasswordField.text?.toString().orEmpty()

                if (password1 == password2) {
                    pwVerTextLayout.error = null
                    pwVerTextLayout.isErrorEnabled = false
                } else if (password1.isEmpty()) {
                    pwVerTextLayout.error = null
                    pwVerTextLayout.isErrorEnabled = false
                } else if (password2.isEmpty()) {
                    pwVerTextLayout.error = null
                    pwVerTextLayout.isErrorEnabled = false
                } else {
                    pwVerTextLayout.error = "Passwords don't match!"
                    pwVerTextLayout.isErrorEnabled = true
                    verPasswordField.addTextChangedListener { text ->

                        pwVerTextLayout.error = null
                        pwVerTextLayout.isErrorEnabled = false

                    }
                }
            }
        }
        emailField.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                val emailText = emailField.text?.toString().orEmpty()

                if (isValid(emailText, "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
                    emailTextLayout.error = null
                    emailTextLayout.isErrorEnabled = false
                } else if (emailText.isEmpty()) {
                    emailTextLayout.error = null
                    emailTextLayout.isErrorEnabled = false
                }else {
                    emailTextLayout.error = "email format is incorrect"
                    emailTextLayout.isErrorEnabled = true
                    emailField.addTextChangedListener { text ->

                        emailTextLayout.error = null
                        emailTextLayout.isErrorEnabled = false
                    }
                }
            }
        }
        cniField.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                val cniText = cniField.text?.toString().orEmpty()

                if (isValid(cniText,  "^[A-Z]{2}\\d{6}$")) {
                    cniTextLayout.error = null
                    cniTextLayout.isErrorEnabled = false
                } else if (cniText.isEmpty()) {
                    cniTextLayout.error = null
                    cniTextLayout.isErrorEnabled = false
                }else {
                    cniTextLayout.error = "CIN format is incorrect"
                    cniTextLayout.isErrorEnabled = true
                    cniField.addTextChangedListener { text ->

                        cniTextLayout.error = null
                        cniTextLayout.isErrorEnabled = false
                    }
                }
            }
        }

        dateNaissanceField.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                dateNaissanceField.hint = "jj/mm/aaaa "

            } else {
                dateNaissanceField.hint = ""
                val dnText = dateNaissanceField.text?.toString().orEmpty()

                if (isValid(dnText, "^\\d{2}/\\d{2}/\\d{4}$")) {
                    dateNTextLayout.error = null
                    dateNTextLayout.isErrorEnabled = false
                } else if (dnText.isEmpty()) {
                    dateNTextLayout.error = null
                    dateNTextLayout.isErrorEnabled = false
                }else {
                    dateNTextLayout.error = "birthday format is incorrect"
                    dateNTextLayout.isErrorEnabled = true
                    dateNaissanceField.addTextChangedListener { text ->

                        dateNTextLayout.error = null
                        dateNTextLayout.isErrorEnabled = false
                    }
                }
            }
        }
        telField.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                val telText = "+212${telField.text?.toString().orEmpty()}"

                if (isValid(telText, "^\\+212\\d{9}$")) {
                    telTextLayout.error = null
                    telTextLayout.isErrorEnabled = false
                } else if (telText == "+212") {
                    dateNTextLayout.error = null
                    dateNTextLayout.isErrorEnabled = false
                }else {
                    telTextLayout.error = "phone format is  incorrect"
                    telTextLayout.isErrorEnabled = true
                    telField.addTextChangedListener { text ->

                        telTextLayout.error = null
                        telTextLayout.isErrorEnabled = false
                    }
                }
            }
        }

        passwordField.addTextChangedListener { editable ->
            val password = editable.toString()

            val isLongEnough = password.length >= 8
            val isNothing = password.isEmpty()
            val hasSymbol = password.any { it.isLetterOrDigit().not() }
            val hasNumber = password.any { it.isDigit() }

            when {
                !isLongEnough -> {
                    pwTextLayout.helperText = "Password must be at least 8 characters"
                }
                !hasSymbol -> {
                    pwTextLayout.helperText = "Password must contain at least one symbol"
                }
                !hasNumber -> {
                    pwTextLayout.helperText = "Password must contain at least one number"
                }
                isNothing -> {
                    pwTextLayout.helperText =" "
                }
                else -> {
                    pwTextLayout.helperText = "Password is strong!"
                    pwTextLayout.setOnFocusChangeListener { _, hasFocus ->
                        if (!hasFocus) {
                            pwTextLayout.helperText = ""
                        }
                    }
                }
            }
        }
        dateNaissanceField.addTextChangedListener(object : TextWatcher {
            private var isEditing = false

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                if (isEditing) return

                isEditing = true
                val text = s.toString().replace("/", "")
                val formattedText = formatDateString(text)
                dateNaissanceField.setText(formattedText)
                dateNaissanceField.setSelection(formattedText.length)
                isEditing = false
            }

            private fun formatDateString(input: String): String {
                val builder = StringBuilder()
                if (input.length > 2) {
                    builder.append(input.substring(0, 2)).append("/")
                    if (input.length > 4) {
                        builder.append(input.substring(2, 4)).append("/")
                        builder.append(input.substring(4, minOf(input.length, 8)))
                    } else {
                        builder.append(input.substring(2))
                    }
                } else {
                    builder.append(input)
                }
                return builder.toString()
            }
        })
    }






    private fun showSuccessDialog() {
        val dialogBuilder = AlertDialog.Builder(requireContext())
        val successIcon: Drawable? = ContextCompat.getDrawable(requireContext(), R.drawable.success)
        successIcon?.colorFilter = PorterDuffColorFilter(
            ContextCompat.getColor(requireContext(), R.color.vectaleColor),
            PorterDuff.Mode.SRC_IN
        )
        dialogBuilder.setTitle("Success")
            .setMessage("Registration successful!!")
            .setIcon(successIcon)
            .setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss()
                findNavController().navigate(R.id.action_signupFragment_to_loginFragment)
            }
            .create()
            .show()
    }

}

