package com.example.vectalemobile.login

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.vectalemobile.MainPage
import com.example.vectalemobile.R
import com.example.vectalemobile.classes.FunctionsClass
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout



class LogIn : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.login_activity, container, false)

        val switchToSignUpButton: TextView = view.findViewById(R.id.switchToSignUpButton)
        switchToSignUpButton.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_signupFragment)
       }
        val vectaleLogoLI = view.findViewById<ImageView>(R.id.vectaleLogo)

        vectaleLogoLI.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.vectalia.ma/safi/presentation"))
            startActivity(intent)
        }


        val pwTextLayout = view.findViewById<TextInputLayout>(R.id.pwLoginText)
        val emailTextLayout = view.findViewById<TextInputLayout>(R.id.emailLoginText)

        val loginEmail = view.findViewById<TextInputEditText>(R.id.loginEmail)
        val loginPassword = view.findViewById<TextInputEditText>(R.id.loginPassword)
        val loginBtn = view.findViewById<Button>(R.id.loginButton)

        loginEmail.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                emailTextLayout.error = null
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        loginPassword.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                pwTextLayout.error = null
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        loginBtn.setOnClickListener {
            if (loginEmail.text.isNullOrEmpty()) {
                emailTextLayout.error = "Email is required"
                return@setOnClickListener
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(loginEmail.text.toString()).matches()) {
                emailTextLayout.error = "Invalid email format"
                return@setOnClickListener
            }
            if (loginPassword.text.isNullOrEmpty()) {
                pwTextLayout.error = "Password is required"
                return@setOnClickListener
            }

            val check = FunctionsClass().findUser(loginEmail.text.toString(), loginPassword.text.toString())
            if (check != -1) {
                val intent = Intent(requireContext(), MainPage::class.java)
                startActivity(intent)
                requireActivity().finish()
            } else {
                emailTextLayout.error = "Invalid email or password"
                pwTextLayout.error = "Invalid email or password"
            }
        }

        return view
    }
}
