package com.example.moviechest.domain

interface Mapper <T> {

    fun map(id: Int, titleId: String, imageId: Int, favorite: Boolean, description: String): T

}