package com.example.recyclerview

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.recyclerview.R

class LoginActivity : AppCompatActivity() {

    private lateinit var usernameInput: EditText
    private lateinit var passwordInput: EditText
    private lateinit var passwordToggle: ImageView
    private lateinit var loginButton: Button
    private lateinit var registerButton: Button
    private var isPasswordVisible = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        usernameInput = findViewById(R.id.usernameInput)
        passwordInput = findViewById(R.id.passwordInput)
        passwordToggle = findViewById(R.id.passwordToggle)
        loginButton = findViewById(R.id.loginButton)
        registerButton = findViewById(R.id.registerButton)

        passwordToggle.setOnClickListener {
            togglePasswordVisibility()
        }
        loginButton.setOnClickListener {
            performLogin()
        }
        registerButton.setOnClickListener{
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }

    private fun togglePasswordVisibility()
    {
        isPasswordVisible = !isPasswordVisible
        if (isPasswordVisible)
        {
            passwordInput.inputType = InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
            passwordToggle.setImageResource(R.drawable.eye_icon_open)
        }
        else
        {
            passwordInput.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
            passwordToggle.setImageResource(R.drawable.eye_icon_close)
        }
        passwordInput.setSelection(passwordInput.text.length)
    }

    private fun performLogin()
    {
        val username = usernameInput.text.toString()
        val password = passwordInput.text.toString()

        if (username.isEmpty() || password.isEmpty())
        {
            Toast.makeText(this, "Please fill in both fields", Toast.LENGTH_SHORT).show()
        }
        else
        {
            Toast.makeText(this, "Logging in...", Toast.LENGTH_SHORT).show()

        }
    }
}

