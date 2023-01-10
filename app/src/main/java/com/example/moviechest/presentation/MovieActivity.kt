package com.example.moviechest.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.moviechest.data.MovieItem
import com.example.moviechest.R
import com.example.moviechest.databinding.ActivityMovieBinding

class MovieActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMovieBinding

    private val movie by lazy { intent.getParcelableExtra<MovieItem>(ARG_MOVIE)!! }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initNavigationBottom()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.movieCard)
        showMovie(movie)
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
                R.id.button_exit -> {
                    onBackPressed()
                }
                else -> {
                    return@setOnItemSelectedListener false
                }
            }
            return@setOnItemSelectedListener true
        }
    }

    companion object {

        private const val ARG_MOVIE = "movie_key"

        fun getIntent(context: Context, movie: MovieItem): Intent {
            return Intent(context, MovieActivity::class.java).apply {
                putExtra(ARG_MOVIE, movie)
            }
        }
    }
}