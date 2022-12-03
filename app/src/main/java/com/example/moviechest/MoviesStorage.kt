package com.example.moviechest

object MoviesStorage {

    private val movies = arrayListOf(
        MovieItem(
            R.string.la_casa_del_papel,
            R.drawable.la_casa_del_papel,
            R.string.buttonItem,
            R.drawable.ic_baseline_favorite_border_24,
            isFavorites = false,
            R.string.laCasaDelPapelDescription
        ),
        MovieItem(
            R.string.razzhimaya_kulaki,
            R.drawable.razhimaya_kulaki,
            R.string.buttonItem,
            R.drawable.ic_baseline_favorite_border_24,
            isFavorites = false,
            R.string.razzhimayaKulakiDescription
        ),
        MovieItem(
            R.string.years_and_years,
            R.drawable.years_and_years,
            R.string.buttonItem,
            R.drawable.ic_baseline_favorite_border_24,
            isFavorites = false,
            R.string.yearsAndYearsDescription
        ),
        MovieItem(
            R.string.bottle_shock,
            R.drawable.bottle_shock,
            R.string.buttonItem,
            R.drawable.ic_baseline_favorite_border_24,
            isFavorites = false,
            R.string.bottleShockDecription
        ),
        MovieItem(
            R.string.perfect_sence,
            R.drawable.perfect_sence,
            R.string.buttonItem,
            R.drawable.ic_baseline_favorite_border_24,
            isFavorites = false,
            R.string.perfectSenceDecription
        ),
        MovieItem(
            R.string.black_sails,
            R.drawable.black_sails,
            R.string.buttonItem,
            R.drawable.ic_baseline_favorite_border_24,
            isFavorites = false,
            R.string.blackSailsDecription
        )
    )

    fun getAllMovies(): List<MovieItem> {
        return movies
    }

    fun getFavoriteMovies(): List<MovieItem> {
        return movies.filter { it.isFavorites }
    }
}
