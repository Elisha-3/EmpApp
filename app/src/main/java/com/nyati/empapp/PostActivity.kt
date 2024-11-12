package com.nyati.empapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.json.JSONObject

class PostActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_post)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
//        fetch the four edit text and one button
        val username = findViewById<EditText>(R.id.username)
        val others = findViewById<EditText>(R.id.others)
        val salary = findViewById<EditText>(R.id.salary)
        val department = findViewById<EditText>(R.id.department)
        val btnsave = findViewById<Button>(R.id.btnsave)
        btnsave.setOnClickListener {
            val api = "https://kens.pythonanywhere.com/employees"
            val body =JSONObject()
            body.put("firstname", username.text.toString())
            body.put("others", others.text.toString())
            body.put("salary", salary.text.toString())
            body.put("department", department.text.toString())

            val helper = ApiHelper(applicationContext)
            helper.post(api,body)


        }




    }
}