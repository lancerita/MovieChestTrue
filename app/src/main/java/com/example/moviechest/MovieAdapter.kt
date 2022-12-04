package com.example.moviechest

import android.annotation.SuppressLint
import android.graphics.Movie
import android.os.Build.VERSION_CODES.M
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView


class MovieAdapter(
    private val listener: MoviesClicklistener
) :
    RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    private var oldList = emptyList<MovieItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MovieViewHolder(inflater.inflate(R.layout.item_movie, parent, false))
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(oldList[position], listener)
    }

    override fun getItemCount(): Int = oldList.size

    fun updateMovieList(newList: List<MovieItem>) {
        this.oldList = newList
        notifyDataSetChanged()
    }

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
