package com.example.finalproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ThirdActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        // Retrieve user information from Intent
        val userEmail = intent.getStringExtra("USER_EMAIL")
        val userFName = intent.getStringExtra("USER_FNAME")

        // Display welcome message and email in TextViews
        val welcomeText = findViewById<TextView>(R.id.welcome)
        welcomeText.text = "Welcome $userFName"

        val emailText = findViewById<TextView>(R.id.email)
        emailText.text = "Email: $userEmail"

        // Logout Button
        val btnLogout = findViewById<Button>(R.id.btnLogout)
        btnLogout.setOnClickListener {
            // Navigate to SecondActivity
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }
}
