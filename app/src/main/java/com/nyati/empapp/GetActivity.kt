package com.nyati.empapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

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
        val sports = findViewById<Button>(R.id.sports)
        sports.setOnClickListener {
            val sports = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.skysports.com/"))
            startActivity(sports)
        }

        // Entertainment Button - Opens YouTube playlist
        val entertainment = findViewById<Button>(R.id.entertainment)
        entertainment.setOnClickListener {
            val entertainmentIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/playlist?list=PLcx7jxmk8lD_lXZnqCU8xJyItImlgaaDx"))
            startActivity(entertainmentIntent)
        }

        // Business Button - Opens Business Daily Africa
        val business = findViewById<Button>(R.id.business)
        business.setOnClickListener {
            val businessIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.businessdailyafrica.com/"))
            startActivity(businessIntent)
        }

        // Education Button - Opens Education News website
        val education = findViewById<Button>(R.id.education)
        education.setOnClickListener {
            val educationIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.educationnews.co.ke//"))
            startActivity(educationIntent)
        }
    }
}