package com.example.moviechest

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviechest.databinding.ActivityMainBinding

lateinit var binding: ActivityMainBinding
val favorites = arrayListOf<MovieItem>()

class MainActivity : AppCompatActivity() {

    private val movies = arrayListOf(
        MovieItem(
            R.string.la_casa_del_papel.toString(),
            R.drawable.la_casa_del_papel,
            R.string.buttonItem.toString(),
            isfavorites = false
        ),
        MovieItem(
            R.string.razzhimaya_kulaki.toString(),
            R.drawable.razhimaya_kulaki,
            R.string.buttonItem.toString(),
            isfavorites = false
        ),
        MovieItem(
            R.string.years_and_years.toString(),
            R.drawable.years_and_years,
            R.string.buttonItem.toString(),
            isfavorites = false
        ),
        MovieItem(
            R.string.bottle_shock.toString(),
            R.drawable.bottle_shock,
            R.string.buttonItem.toString(),
            isfavorites = false
        ),
                MovieItem(
                R.string.perfect_sence.toString(),
        R.drawable.perfect_sence,
        R.string.buttonItem.toString(),
                    isfavorites = false
                ),
                MovieItem(
                R.string.black_sails.toString(),
                    R.drawable.black_sails,
                    R.string.buttonItem.toString(),
                    isfavorites = false
                    )
        )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecycler()
        goToFavorites()
            }

    private fun goToFavorites() {
        binding.bottomNavigation?.setOnClickListener {
            when (it.id) {
                R.id.button_favorites ->
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_full_screen, FavoritesFragment())
                        .commit()
                    }
            Log.d("smth", "Go to Favorites" )
}
        //Но во фрагмент по кнопке на BottomNavigation так и не переходит((
    }

    private fun initRecycler() {
        binding.apply {
            recycler.layoutManager = LinearLayoutManager(this@MainActivity)
            recycler.adapter = MovieAdapter(movies, object : MovieAdapter.MoviesClicklistener {
                override fun onMoviesClick (item: MovieItem) {
                    Toast.makeText(this@MainActivity, "Details Click", Toast.LENGTH_SHORT).show()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_full_screen, LaCasaDelPapel())
                        .commit()
                 //Фрагмент открывается, но логика неправильная.
                //Как сделать, чтобы открывался фрагмент именно с тем фильмом, который щелкнули?
                //Нужны отдельные функции на каждый фильм?
                //Но как тогда найти id каждой конкретной кнопки? Если все заполняется через RV.
                                   }

//Где делать функцию добавления фильма в список favorites, когда isfavorites=true? В МА или во фрагменте?
// Как конкретно это сделать?
                override fun onFavoriteClick(item: MovieItem) {
                    Toast.makeText(this@MainActivity, "Favorite Click", Toast.LENGTH_SHORT).show()
                    item.isfavorites = true
                }
            })
        }
    }
    //Нужно перейти во фрагмент с фильмом
    /*fun openLaCasaDelPapel() {
val details = binding.recycler.findViewHolderForItemId()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_full_screen, LaCasaDelPapel())
            .commit()
    }*/

    //Добавляю один фильм в избранное вручную, чтобы проверить работу
    fun addToFavorites(){
        favorites.add(MovieItem(
            R.string.black_sails.toString(),
            R.drawable.black_sails,
            R.string.buttonItem.toString(),
            isfavorites = true
        ))
    }
    }

