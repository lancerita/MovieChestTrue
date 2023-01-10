package com.example.moviechest.domain

import androidx.recyclerview.widget.DiffUtil
import com.example.moviechest.data.MovieItem

class MovieItemDiffCallBack : DiffUtil.ItemCallback<MovieItem>() {
    override fun areItemsTheSame(oldItem: MovieItem, newItem: MovieItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: MovieItem, newItem: MovieItem): Boolean {
        return oldItem == newItem
    }
}