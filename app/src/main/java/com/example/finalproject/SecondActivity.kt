package com.example.finalproject

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    private lateinit var loginEmail: EditText
    private lateinit var loginPassword: EditText
    private lateinit var btnLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        loginEmail = findViewById(R.id.login_email)
        loginPassword = findViewById(R.id.login_password)
        btnLogin = findViewById(R.id.btnLogin)

        btnLogin.setOnClickListener {
            loginUser()
        }
    }

    private fun loginUser() {
        val email = loginEmail.text.toString().trim()
        val password = loginPassword.text.toString().trim()

        val databaseHandler = DatabaseHandler(this)

        if (email.isNotEmpty() && password.isNotEmpty()) {
            if (email == "admin" && password == "admin") {
                // Admin credentials, navigate to FourthActivity
                val intent = Intent(this, FourthActivity::class.java)
                startActivity(intent)
                finish() // Optionally finish the current activity
            } else {
                // Regular user credentials, check against the database
                databaseHandler.checkCredentials(email, password)?.let { user ->
                    // Credentials are correct, proceed to ThirdActivity
                    val intent = Intent(this, ThirdActivity::class.java).apply {
                        // Pass user information to ThirdActivity
                        putExtra("USER_EMAIL", user.userEmail)
                        putExtra("USER_FNAME", user.userFName)
                    }
                    startActivity(intent)
                    finish() // Optionally finish the current activity
                } ?: run {
                    // Credentials are incorrect, show a toast message
                    Toast.makeText(this, "Incorrect email or password", Toast.LENGTH_LONG).show()
                }
            }
        } else {
            // Empty fields, show a toast message
            Toast.makeText(this, "Please enter both email and password", Toast.LENGTH_LONG).show()
        }
    }



    fun goToRegister(view: View) {
        val textView = findViewById<TextView>(R.id.txt_register)

        // Set a click listener for the TextView
        textView.setOnClickListener {
            // Create an Intent to start the SecondActivity
            val intent = Intent(this, MainActivity::class.java)
            // Start the SecondActivity
            startActivity(intent)
        }
    }
}