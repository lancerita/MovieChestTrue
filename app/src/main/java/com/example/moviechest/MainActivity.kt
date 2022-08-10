package com.example.moviechest

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

lateinit var filmName1 : TextView
lateinit var filmName2 : TextView
lateinit var filmName3 : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_main)

            filmName1 = findViewById<TextView>(R.id.filmName1)
            val button1 = findViewById<Button>(R.id.button1)
        button1.setOnClickListener{
filmName1.setTextColor(Color.parseColor("#FF03DAC5"))
            startActivity(Intent(this, LaCasaDelPapel::class.java))
        }
        filmName2 = findViewById<TextView>(R.id.filmName2)
        val button2 = findViewById<Button>(R.id.button2)
        button2.setOnClickListener {
            filmName2.setTextColor(Color.parseColor("#FF03DAC5"))
            startActivity(Intent(this, YearsAndYears::class.java))
        }

        filmName3 = findViewById<TextView>(R.id.filmName3)
        val button3 = findViewById<Button>(R.id.button3)
        button3.setOnClickListener {
            filmName3.setTextColor(Color.parseColor("#FF03DAC5"))
            startActivity(Intent(this, RazhimayaKulaki::class.java))
        }

        findViewById<Button>(R.id.buttonInvite).setOnClickListener{
findViewById<TextView>(R.id.EmailAddress).visibility = View.VISIBLE
        }
    }
    }


