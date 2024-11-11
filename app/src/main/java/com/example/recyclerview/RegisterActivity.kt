package com.example.recyclerview

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.recyclerview.LoginActivity
import com.example.recyclerview.R

class RegisterActivity : AppCompatActivity() {
    private lateinit var userNameInput: EditText
    private lateinit var emailInput: EditText
    private lateinit var passwordInput: EditText
    private lateinit var confirmPasswordInput: EditText
    private lateinit var passwordToggle: ImageView
    private lateinit var confirmPasswordToggle: ImageView
    private lateinit var registerButton: Button
    private var isPasswordVisible = false
    private var isConfirmPasswordVisible = false

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        userNameInput = findViewById(R.id.usernameInput)
        emailInput = findViewById(R.id.emailInput)
        passwordInput = findViewById(R.id.passwordInput)
        confirmPasswordInput = findViewById(R.id.confirmPasswordInput)
        passwordToggle = findViewById(R.id.passwordToggle)
        confirmPasswordToggle = findViewById(R.id.confirmPasswordToggle)
        registerButton = findViewById(R.id.registerButton)

        passwordToggle.setOnClickListener {
            togglePasswordVisibility()
        }
        confirmPasswordToggle.setOnClickListener {
            toggleConfirmPasswordVisibility()
        }

        registerButton.setOnClickListener {
            val username = userNameInput.text.toString()
            val email = emailInput.text.toString()
            val password = passwordInput.text.toString()
            val confirmpass = confirmPasswordInput.text.toString()
            if (username.isEmpty() ||email.isEmpty() || password.isEmpty() || confirmpass.isEmpty())
            {
                Toast.makeText(this, "Please fill in both fields", Toast.LENGTH_SHORT).show()
            }
            else if(password != confirmpass) {
                Toast.makeText(this, "Password and ConfirmPassword is not match,please check it..", Toast.LENGTH_SHORT).show()
            }
            else
            {
                Toast.makeText(this, "Registration successfully!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }


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

    private fun toggleConfirmPasswordVisibility()
    {
        isConfirmPasswordVisible = !isConfirmPasswordVisible
        if (isConfirmPasswordVisible)
        {
            confirmPasswordInput.inputType = InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
            confirmPasswordToggle.setImageResource(R.drawable.eye_icon_open)
        }
        else
        {
            confirmPasswordInput.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
            confirmPasswordToggle.setImageResource(R.drawable.eye_icon_close)
        }
        confirmPasswordInput.setSelection(confirmPasswordInput.text.length)
    }
}
