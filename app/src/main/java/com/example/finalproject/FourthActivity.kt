package com.example.finalproject

import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class FourthActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.admin_homepage)
    }

    fun viewRecord(view: View) {
        val databaseHandler: DatabaseHandler = DatabaseHandler(this)
        val emp: List<EmpModelClass> = databaseHandler.viewEmployee()
        val empArrayEmail = Array<String>(emp.size) {"null"}
        val empArrayFName = Array<String>(emp.size) {"null"}
        val empArrayPassword = Array<String>(emp.size) {"null"}
        var index = 0
        for(e in emp) {
            empArrayEmail[index] = e.userEmail
            empArrayFName[index] = e.userFName
            empArrayPassword[index] = e.userPassword
            index++
        }
        val listview = findViewById<ListView>(R.id.listView)
        val myListAdapter = MyListAdapter(this,empArrayEmail,empArrayFName,empArrayPassword)
        listview.adapter = myListAdapter
    }

    fun updateRecord(view: View) {
        val dialogBuilder = AlertDialog.Builder(this)
        val inflater = this.layoutInflater
        val dialogView = inflater.inflate(R.layout.update_dialog,null)
        dialogBuilder.setView(dialogView)

        val editEmail = dialogView.findViewById<EditText>(R.id.updateEmail)
        val editFName = dialogView.findViewById<EditText>(R.id.updateFName)
        val editPassword = dialogView.findViewById<EditText>(R.id.updatePassword)

        dialogBuilder.setTitle("Update Record")
        dialogBuilder.setMessage("Enter data below")
        dialogBuilder.setPositiveButton("Update", DialogInterface.OnClickListener { dialogInterface, i ->
            val updateEmail = editEmail.text.toString()
            val updateFName = editFName.text.toString()
            val updatePassword = editPassword.text.toString()
            val databaseHandler: DatabaseHandler = DatabaseHandler(this)

            if(updateEmail.trim()!="" && updateFName.trim()!="" && updatePassword.trim()!="") {
                val status = databaseHandler.updateEmployee(EmpModelClass(updateEmail,updateFName,updatePassword))
                if(status > -1) {
                    Toast.makeText(this, "Record Updated", Toast.LENGTH_LONG).show()
                }
            } else {
                Toast.makeText(this, "ID or name or Email cannot be blank", Toast.LENGTH_LONG).show()
            }
        })
        dialogBuilder.setNegativeButton("Cancel", DialogInterface.OnClickListener { dialogInterface, i ->

        })

        val b = dialogBuilder.create()
        b.show()
    }

    fun deleteRecord(view: View) {
        val dialogBuilder = AlertDialog.Builder(this)
        val inflater = this.layoutInflater
        val dialogView = inflater.inflate(R.layout.delete_dialog,null)
        dialogBuilder.setView(dialogView)

        val editEmail = dialogView.findViewById<EditText>(R.id.deleteEmail)

        dialogBuilder.setTitle("Delete Record")
        dialogBuilder.setMessage("Enter data below")
        dialogBuilder.setPositiveButton("Delete", DialogInterface.OnClickListener { dialogInterface, i ->
            val deleteId = editEmail.text.toString()
            val databaseHandler: DatabaseHandler = DatabaseHandler(this)

            if(deleteId.trim()!="") {
                val status = databaseHandler.deleteEmployee(EmpModelClass(deleteId,"",""))
                if(status > -1) {
                    Toast.makeText(this, "Record Deleted", Toast.LENGTH_LONG).show()
                }
            } else {
                Toast.makeText(this, "ID or name or Email or Password cannot be blank", Toast.LENGTH_LONG).show()
            }
        })
        dialogBuilder.setNegativeButton("Cancel", DialogInterface.OnClickListener { dialogInterface, i ->

        })

        val b = dialogBuilder.create()
        b.show()
    }

}