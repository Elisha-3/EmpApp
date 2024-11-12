package com.nyati.empapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.json.JSONArray

class GetActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_get)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
             v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
//        fetch the progressbar and the textview
        val progress = findViewById<ProgressBar>(R.id.progress)
            val empdata = findViewById<TextView>(R.id.empdata)

//        get our base url/endpoint
        val api = "https://kens.pythonanywhere.com/employees"

//        get instance of api helper; meaning we create an object of API helper
        val helper = ApiHelper(applicationContext)
        helper.get("https://kens.pythonanywhere.com/employees", object:ApiHelper.CallBack{
            override fun onSuccess(result: String?) {
//                covert to json array
                val employeejsonarray = JSONArray(result.toString())
//                Toast.makeText(applicationContext, "$employeejsonarray", Toast.LENGTH_SHORT).show()
//                loop through the data
                (0 until employeejsonarray.length()).forEach {
                    val singleemployee = employeejsonarray.getJSONObject(it)
//                    Toast.makeText(applicationContext, "$singleemployee", Toast.LENGTH_SHORT).show()
//                    display user id in a textview
                    empdata.append("Employee ID" + singleemployee.get("id")  +"\n")
                    empdata.append("First Name" + singleemployee.get("firstname")  +"\n")
                    empdata.append("Others"  + singleemployee.get("others")  +"\n")
                    empdata.append("Salary"  +  singleemployee.get("salary")  +"\n")
                    empdata.append("Department"  + singleemployee.get("department")  +"\n")
                    empdata.append("\n\n\n")

                }
//                stop progress bar from loading once you have the result
                progress.visibility = View.GONE

            }
        })

    }
}