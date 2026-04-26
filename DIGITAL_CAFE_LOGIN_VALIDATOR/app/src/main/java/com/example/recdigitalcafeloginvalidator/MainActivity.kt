package com.example.recdigitalcafeloginvalidator

import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val email = findViewById<EditText>(R.id.editTextEmail)
        val password = findViewById<EditText>(R.id.editTextPassword)
        val button = findViewById<Button>(R.id.buttonValidate)
        val result = findViewById<TextView>(R.id.textViewResult)

        button.setOnClickListener {

            val emailText = email.text.toString()
            val passwordText = password.text.toString()

            if (emailText.isEmpty() || passwordText.isEmpty()) {
                result.text = "Fields should not be empty"
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(emailText).matches() ||
                !emailText.endsWith("@college.edu")) {
                result.text = "Enter valid college email ID"
                return@setOnClickListener
            }

            val passwordPattern =
                Regex("^(?=.*[A-Z])(?=.*[0-9])(?=.*[@#\$%^&+=!]).{12,}$")

            if (!passwordPattern.matches(passwordText)) {
                result.text = "Password must be 12 chars, 1 uppercase, 1 number, 1 special symbol"
                return@setOnClickListener
            }

            result.text = "Validation Successful"
        }
    }
}