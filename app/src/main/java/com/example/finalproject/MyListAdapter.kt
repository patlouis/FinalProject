package com.example.finalproject

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class MyListAdapter(private val context: Activity, private val email: Array<String>, private val firstName: Array<String>, private val password: Array<String>)
    :ArrayAdapter<String>(context, R.layout.custom_list, firstName) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = context.layoutInflater
        val rowView = inflater.inflate(R.layout.custom_list, null, true)

        val emailText = rowView.findViewById<TextView>(R.id.textViewEmail)
        val fNameText = rowView.findViewById<TextView>(R.id.textViewFName)
        val lNameText = rowView.findViewById<TextView>(R.id.textViewLName)
        val passwordText = rowView.findViewById<TextView>(R.id.textViewPassword)

        emailText.text = "Email: ${email[position]}"
        fNameText.text = "First Name: ${firstName[position]}"
        passwordText.text = "Last Name: ${password[position]}"

        return rowView
    }
}