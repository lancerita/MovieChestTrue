package com.example.moviechest

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


class MovieAdapter(
    val movies: List<MovieItem>
    ) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MovieViewHolder(inflater.inflate(R.layout.item_movie, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is MovieViewHolder -> {
                holder.bind(movies[position])
            }
        }
    }

    override fun getItemCount(): Int = movies.size


    /*public interface MoviesClickListener {
        fun onMoviesClick (movieItem: MovieItem, position: Int)
        fun onFavoriteClick (movieItem: MovieItem, position: Int)
    }*/


}

