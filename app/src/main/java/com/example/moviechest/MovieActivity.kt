package com.example.moviechest

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.moviechest.databinding.ActivityMovieBinding

class MovieActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMovieBinding

    private val movie by lazy { intent.getParcelableExtra<MovieItem>("OPEN_MOVIE") }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initNavigationBottom()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.movieCard)
        showMovie(movie!!)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) finish()
        return true
    }

    private fun showMovie(movie: MovieItem) {
        binding.apply {
            nameTextView.setText(movie.titleId)
            imageView.setImageResource(movie.imageId)
            descriptionTextView.setText(movie.description)
        }
    }

    private fun initNavigationBottom() {
        binding.bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.button_favorites -> {
                    supportFragmentManager.beginTransaction()
                        .replace(
                            R.id.fragment_container,
                            MoviesFragment.newInstance(isFavourite = true)
                        )
                        .addToBackStack(null)
                        .commit()
                    supportActionBar?.title = getString(R.string.favorites)
                }
                R.id.button_all_movies -> {
                    supportFragmentManager.beginTransaction()
                        .replace(
                            R.id.fragment_container,
                            MoviesFragment.newInstance(isFavourite = false)
                        )
                        .commit()
                    supportActionBar?.title = getString(R.string.allMovies)
                }

                else -> {
                    return@setOnItemSelectedListener false
                }
            }
            return@setOnItemSelectedListener true
        }
    }

}