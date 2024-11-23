package com.example.signupactivity

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etName = findViewById<EditText>(R.id.etName)
        val etContact = findViewById<EditText>(R.id.etContact)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val etAddress = findViewById<EditText>(R.id.etAddress)
        val btnSubmit = findViewById<Button>(R.id.btnSubmit)

        btnSubmit.setOnClickListener {
            if (validateFields(etName, etContact, etEmail, etPassword, etAddress)) {
                Toast.makeText(this, "Sign-Up Successful!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun validateFields(
        etName: EditText,
        etContact: EditText,
        etEmail: EditText,
        etPassword: EditText,
        etAddress: EditText
    ): Boolean {
        var isValid = true

        if (etName.text.isEmpty()) {
            etName.error = "Name cannot be empty"
            isValid = false
        }
        if (etContact.text.isEmpty() || !etContact.text.matches(Regex("\\d{10}"))) {
            etContact.error = "Enter a valid 10-digit contact number"
            isValid = false
        }
        if (etEmail.text.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(etEmail.text).matches()) {
            etEmail.error = "Enter a valid email"
            isValid = false
        }
        if (etPassword.text.isEmpty() || etPassword.text.length < 6) {
            etPassword.error = "Password must be at least 6 characters"
            isValid = false
        }
        if (etAddress.text.isEmpty()) {
            etAddress.error = "Address cannot be empty"
            isValid = false
        }

        return isValid
    }
}