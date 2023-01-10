package com.example.moviechest.data

import com.example.moviechest.domain.Mapper

interface Movie {

    fun <T> map(mapper: Mapper<T>): T

    class Base(
        private val id: Int = 0,
        private val titleId: String,
        private val imageId: Int,
        private val favorite: Boolean,
        private val description: String
    ) : Movie {

        override fun <T> map(mapper: Mapper<T>): T =
            mapper.map(id, titleId, imageId, favorite, description)
    }

    class MakeFavorite(private val favorite: Boolean) : Mapper<Boolean> {

        override fun map(
            id: Int,
            titleId: String,
            imageId: Int,
            favorite: Boolean,
            description: String
        ): Boolean {
            return true
            }
        }
    }

fun main() {
    val movie = Movie.Base(0, "dgd", 1, false, "sgs")
    val result = movie.map(Movie.MakeFavorite(false))
    print(result)
}