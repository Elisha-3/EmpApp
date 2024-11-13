package com.nyati.empapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.json.JSONObject

class PutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_put)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val idedittext = findViewById<EditText>(R.id.empid)
        val nameedittext = findViewById<EditText>(R.id.empname)
        val btnupdate = findViewById<Button>(R.id.update)
        btnupdate.setOnClickListener {
            val api = "https://kens.pythonanywhere.com/employees"
            val body = JSONObject()
            body.put("id", idedittext.text.toString())
            body.put("firstname", nameedittext.text.toString())
            val helper = ApiHelper(applicationContext)
            helper.put(api, body)
        }

    }
}