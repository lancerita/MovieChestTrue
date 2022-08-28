package com.example.moviechest

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moviechest.R.layout.item_movie

private val movies = mutableListOf(
    MovieItem(
        R.string.la_casa_del_papel.toString(),
        R.drawable.la_casa_del_papel,
        R.string.buttonItem.toString()
    ),
    MovieItem(
        R.string.razzhimaya_kulaki.toString(),
        R.drawable.razhimaya_kulaki,
        R.string.buttonItem.toString()
    ),
    MovieItem(
        R.string.years_and_years.toString(),
        R.drawable.years_and_years,
        R.string.buttonItem.toString()
    )
)
class MainActivity : AppCompatActivity() {

    private val recyclerView by lazy { findViewById<RecyclerView>(R.id.recycler) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecycler()
//      initClickListeners()


    }

    private fun initRecycler() {
        val adapter = MovieAdapter(movies)
        val layoutManager = LinearLayoutManager(this)
          recyclerView.layoutManager = layoutManager
           recyclerView.adapter = adapter

        }

    }



