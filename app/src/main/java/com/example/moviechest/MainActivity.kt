package com.example.moviechest

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.moviechest.databinding.ActivityMainBinding

lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        goToAllMovies()
        initNavigationBottom()
    }

    private fun goToAllMovies() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, MoviesFragment.newInstance(isFavourite = false))
            .commit()
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

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId ==android.R.id.home) finish()
        return true
    }
}
