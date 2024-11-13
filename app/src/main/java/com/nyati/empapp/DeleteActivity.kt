package com.nyati.empapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.json.JSONObject

class DeleteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_delete)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val idedittext = findViewById<EditText>(R.id.id_number)
        val btndelete = findViewById<Button>(R.id.delete)
        btndelete.setOnClickListener {
            val helper = ApiHelper(applicationContext)
            val api = "https://kens.pythonanywhere.com/employees"
            val body = JSONObject()
            body.put("id", idedittext.text.toString())
            helper.delete(api, body)
        }
    }
}