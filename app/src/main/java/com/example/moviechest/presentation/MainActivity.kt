package com.example.moviechest.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.moviechest.R
import com.example.moviechest.databinding.ActivityMainBinding
import com.example.moviechest.presentation.MoviesFragment

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
                    val exitDialogFragment = ExitDialogFragment()
                    exitDialogFragment.show(
                        supportFragmentManager,
                        "exitDialog"
                    )
                }
                else -> {
                    return@setOnItemSelectedListener false
                }
            }
            return@setOnItemSelectedListener true
        }
    }
}
