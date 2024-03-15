package com.example.registration

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.lifecycle.viewmodel.viewModelFactory

class DbHelper(val context: Context, val factory: SQLiteDatabase.CursorFactory?): SQLiteOpenHelper(context, "UserInfo", factory, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        val query = "CREATE TABLE users (id INT PRIMARY KEY, Name TEXT, Email TEXT, Password TEXT )"
        db!!.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS users")
        onCreate(db)
    }
    fun addUser(user: User){
        val values = ContentValues()
        values.put("name", user.name)
        values.put("email", user.email)
        values.put("password",user.pass)

        val database = this.writableDatabase
        database.insert("users", null, values)

        database.close()
    }
}
