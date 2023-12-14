package com.example.finalproject

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHandler(context: Context): SQLiteOpenHelper(context,
    DATABASE_NAME,null,
    DATABASE_VERSION
) {
    companion object{
        private val DATABASE_VERSION = 3
        private val DATABASE_NAME = "UserDatabase"
        private val TABLE_CONTACTS = "UserTable"
        private val KEY_EMAIL ="id"
        private val KEY_FNAME ="name"
        private val KEY_PASSWORD = "password"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_CONTACTS_TABLE = ("CREATE TABLE " + TABLE_CONTACTS + "("
                + KEY_EMAIL + " VARCHAR PRIMARY KEY,"
                + KEY_FNAME + " VARCHAR,"
                + KEY_PASSWORD + " VARCHAR)")
        db?.execSQL(CREATE_CONTACTS_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $TABLE_CONTACTS")
        onCreate(db)
    }

    fun addEmployee(emp: EmpModelClass): Long {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(KEY_EMAIL, emp.userEmail)
        contentValues.put(KEY_FNAME, emp.userFName)
        contentValues.put(KEY_PASSWORD, emp.userPassword)

        val success = db.insert(TABLE_CONTACTS, null, contentValues)
        db.close()
        return success
    }

    @SuppressLint("Range")
    fun viewEmployee():List<EmpModelClass> {
        val empList:ArrayList<EmpModelClass> = ArrayList<EmpModelClass>()
        val selectQuery = "SELECT * FROM $TABLE_CONTACTS"
        val db = this.readableDatabase
        var cursor: Cursor? = null

        try {
            cursor = db.rawQuery(selectQuery, null)
        }
        catch (e: SQLiteException) {
            db.execSQL(selectQuery)
            return ArrayList()
        }
        var userEmail: String
        var userFName: String
        var userLName: String
        var userPassword: String

        if(cursor.moveToFirst()) {
            do {
                userEmail = cursor.getString(cursor.getColumnIndex("id"))
                userFName = cursor.getString(cursor.getColumnIndex("name"))
                userPassword = cursor.getString(cursor.getColumnIndex("password"))
                val emp = EmpModelClass(userEmail = userEmail, userFName = userFName, userPassword = userPassword)
                empList.add(emp)
            } while(cursor.moveToNext())
        }
        return empList
    }

    /*
    // Check if the given email already exists in the database
    fun isEmailExists(email: String): Boolean {
        val db = this.readableDatabase
        val query = "SELECT * FROM $TABLE_CONTACTS WHERE $KEY_EMAIL = ?"
        val cursor = db.rawQuery(query, arrayOf(email))

        val exists = cursor.count > 0

        cursor.close()
        db.close()

        return exists
    }
    */

    fun checkCredentials(email: String, password: String): EmpModelClass? {
        val empList = viewEmployee()

        for (emp in empList) {
            if (emp.userEmail == email && emp.userPassword == password) {
                return emp
            }
        }
        return null
    }

    fun updateEmployee(emp: EmpModelClass) : Int {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(KEY_EMAIL, emp.userEmail)
        contentValues.put(KEY_FNAME, emp.userFName)
        contentValues.put(KEY_PASSWORD, emp.userPassword)

        val success = db.update(TABLE_CONTACTS, contentValues, "id= " + emp.userEmail, null)
        db.close()
        return success
    }

    fun deleteEmployee(emp: EmpModelClass): Int {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(KEY_EMAIL, emp.userEmail)
        val success = db.delete(TABLE_CONTACTS, "id= ?", arrayOf(emp.userEmail))
        db.close()
        return success
    }
}