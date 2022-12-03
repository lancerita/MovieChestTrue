package com.example.moviechest

import android.os.Parcelable
import androidx.annotation.StringRes
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieItem(
    @StringRes
    val titleId: Int,
    val imageId: Int,
    val buttonDetails: Int,
    val imageButtonMakeFavorite: Int,
    var isFavorites: Boolean,
    val description: Int,
    val id: Int = 0
) : Parcelable

//private companion object: Parceler<MovieItem> {
//    override fun MovieItem.write(parcel: Parcel, flags: Int) {
//
//    }
//
//    override fun create(parcel: Parcel): MovieItem {
//
//    }
//}

