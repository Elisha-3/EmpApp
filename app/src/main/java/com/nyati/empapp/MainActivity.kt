package com.nyati.empapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btnpost = findViewById<Button>(R.id.post)
        btnpost.setOnClickListener {

            Toast.makeText(applicationContext, "POST EMPLOYEE BUTTON", Toast.LENGTH_SHORT).show()
          val  intent= Intent(applicationContext, PostActivity::class.java)
          startActivity(intent)
        }

        val btnget = findViewById<Button>(R.id.get)
        btnget.setOnClickListener {
            Toast.makeText(applicationContext, "GET EMPLOYEE BUTTON", Toast.LENGTH_LONG).show()
            val  intent= Intent(applicationContext, GetActivity::class.java)
            startActivity(intent)
        }
        val btnput = findViewById<Button>(R.id.put)
        btnput.setOnClickListener {
            Toast.makeText(applicationContext, "PUT EMPLOYEE BUTTON", Toast.LENGTH_SHORT).show()
            val  intent= Intent(applicationContext, PutActivity::class.java)
            startActivity(intent)
        }
        val btndelete = findViewById<Button>(R.id.delete)
        btndelete.setOnClickListener {
            Toast.makeText(applicationContext, "DELETE EMPLOYEE BUTTON", Toast.LENGTH_SHORT).show()
            val  intent= Intent(applicationContext, DeleteActivity::class.java)
            startActivity(intent)

        }



    }
}