package com.example.finalproject

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun saveRecord(view: View) {
        val u_id = findViewById<EditText>(R.id.register_email)
        val u_name = findViewById<EditText>(R.id.register_firstName)
        val u_password = findViewById<EditText>(R.id.register_password)

        val id = u_id.text.toString()
        val name = u_name.text.toString()
        val password = u_password.text.toString()

        val databaseHandler: DatabaseHandler = DatabaseHandler(this)

        if (id.trim() == "" || name.trim() == "" || password.trim() == "") {
            Toast.makeText(
                this,
                "Please enter valid data. Email, full name, and password cannot be blank",
                Toast.LENGTH_LONG
            ).show()
            return
        }
        /*
        // Check if email already exists in the database
        else if (id.trim() != "" || name.trim() != "" || email.trim() != "" || password.trim() != "" && databaseHandler.isEmailExists(email)) {
                Toast.makeText(this, "Email already exists. Please use a different email.", Toast.LENGTH_LONG).show()
                return
            }
         */

        // Checks if the password is allowed
        if (!isPasswordValid(password)) {
            Toast.makeText(
                this,
                "Password must contain a small letter, capital letter, digit, special character, and have a minimum length of 8 characters",
                Toast.LENGTH_LONG
            ).show()
            return
        }

        val status = databaseHandler.addEmployee(EmpModelClass(id, name, password))
        if (status > -1) {
            Toast.makeText(this, "Registered", Toast.LENGTH_LONG).show()
            clearFields(u_id, u_name, u_password)
            showSignInDialog()
        }
    }

    // Function that checks if the password is valid
    private fun isPasswordValid(password: String): Boolean {
        val passwordPattern = Regex("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@\$!%*?&_#<>~^)(])[A-Za-z\\d@$!%*?&_#<>~^()]{8,}\$")
        return passwordPattern.matches(password)
    }
    // Create admin account with these conditions
    /* private fun isPasswordValid(password: String): Boolean {
    // Remove all conditions, allow any string of length 1 or more
    val passwordPattern = Regex("^.{1,}$")
    return passwordPattern.matches(password)
    }
    */

    // Prompts a message after a successful registration
    private fun showSignInDialog() {
        val dialogBuilder = AlertDialog.Builder(this)
        dialogBuilder.setTitle("Registration Successful")
        dialogBuilder.setMessage("Would you like to sign in using your username and password?")
        dialogBuilder.setPositiveButton("Sign In", DialogInterface.OnClickListener { dialogInterface, i ->
            // Navigate to SecondActivity
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
            finish() // Optionally finish the current activity
        })
        dialogBuilder.setNegativeButton("Cancel", DialogInterface.OnClickListener { dialogInterface, i ->
            // User chose to cancel, dismiss the dialog
            Toast.makeText(this, "Registration successful. You can sign in later.", Toast.LENGTH_LONG).show()
            dialogInterface.dismiss()
        })
        val signInDialog = dialogBuilder.create()
        signInDialog.show()
    }

    // Function that clears the editTexts
    private fun clearFields(vararg editTexts: EditText) {
        for (editText in editTexts) {
            editText.text.clear()
        }
    }

    fun goToLogin(view:View) {
        val textView = findViewById<TextView>(R.id.txt_login)

        // Set a click listener for the TextView
        textView.setOnClickListener {
            // Create an Intent to start the SecondActivity
            val intent = Intent(this, SecondActivity::class.java)
            // Start the SecondActivity
            startActivity(intent)
        }
    }

}