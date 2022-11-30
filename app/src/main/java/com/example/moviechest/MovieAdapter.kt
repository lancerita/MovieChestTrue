package com.example.moviechest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView


class MovieAdapter(
    private val movies: List<MovieItem>,
    val listener: MoviesClicklistener
) :
    RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MovieViewHolder(inflater.inflate(R.layout.item_movie, parent, false))
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movies[position], listener)
    }

    fun updateMovie(movie: MovieItem) {
        val position = movies.indexOf(movie)
        if (position > 0) {
            notifyItemChanged(position)
        }
    }

    override fun getItemCount(): Int = movies.size

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleText: TextView = itemView.findViewById(R.id.textViewItem)
        val pictureImage: ImageView = itemView.findViewById(R.id.imageViewItem)
        val buttonDetails: Button = itemView.findViewById(R.id.buttonItem)
        val buttonMakeFavorite: ImageView = itemView.findViewById(R.id.buttonMakeFavorite)

        fun bind(item: MovieItem, listener: MoviesClicklistener) {
            titleText.setText(item.titleId)
            buttonDetails.setText(item.buttonDetails)
            pictureImage.setImageResource(item.imageId)
            buttonDetails.setOnClickListener {
                listener.onMoviesClick(item)
            }
            buttonMakeFavorite.setImageResource(item.imageButtonMakeFavorite)
            buttonMakeFavorite.setOnClickListener {
                listener.onFavoriteClick(item, adapterPosition)
            }
        }
    }

    interface MoviesClicklistener {
        fun onMoviesClick(movie: MovieItem)
        fun onFavoriteClick(item: MovieItem, position: Int)
    }
}
