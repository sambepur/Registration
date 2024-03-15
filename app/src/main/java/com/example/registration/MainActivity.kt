package com.example.registration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userName = findViewById<EditText>(R.id.name)
        val userPass = findViewById<EditText>(R.id.pass)
        val userEmail = findViewById<EditText>(R.id.email)
        val Reg = findViewById<Button>(R.id.reg)

        Reg.setOnClickListener {
            val Name = userName.text.toString().trim()
            val Pass = userPass.text.toString().trim()
            val Email = userEmail.text.toString().trim()

            if (Name == "" || Pass == "" || Email == "")
                Toast.makeText(this, "all gaps must be field", Toast.LENGTH_SHORT).show()
            else{
                val user = User(Name, Pass, Email)
                val database = DbHelper(this, null)
                database.addUser(user)
                Toast.makeText(this, "user $Name added", Toast.LENGTH_SHORT).show()

                userName.text.clear()
                userEmail.text.clear()
                userPass.text.clear()
            }
        }
    }
}