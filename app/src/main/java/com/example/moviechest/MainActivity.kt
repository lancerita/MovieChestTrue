package com.example.moviechest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moviechest.databinding.ActivityMainBinding

lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {

   // private val recyclerView = findViewById<RecyclerView>(R.id.recycler)
    //val adapter() = MovieAdapter()
    private var movies = arrayListOf<MovieItem>(
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


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecycler()
//      initClickListeners()

    }

    private fun initRecycler() {
        binding.apply {
            recycler?.layoutManager = LinearLayoutManager(this@MainActivity)
            recycler?.adapter = MovieAdapter(movies)
        }

    }


}








