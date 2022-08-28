package com.example.moviechest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class MovieAdapter(private var movies: ArrayList<MovieItem>): RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MovieViewHolder(inflater.inflate(R.layout.item_movie, parent, false))
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        when (holder) {
            is MovieViewHolder -> {
                holder.bind(movies[position])
            }
        }
    }

    override fun getItemCount(): Int = movies.size

    fun updateAdapter(items: ArrayList<MovieItem>) {
        movies.clear()
        movies.addAll(items)
        notifyDataSetChanged()
    }

    /*fun addAll (list: List<MovieItem>) {
        this.movies
        notifyDataSetChanged()
    }*/

  /*  fun submitList(movies: List<String>) {
        this.movies = movies //+ "123"
        notifyDataSetChanged()
    }*/


    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.textViewItem)
        val image: ImageView = itemView.findViewById(R.id.imageViewItem)
        val button: TextView = itemView.findViewById(R.id.buttonItem)

        fun bind(item: MovieItem) {
            title.text = item.title
            button.text = item.button
            image.setImageResource(item.imageId)

            /*public interface MoviesClickListener {
        fun onMoviesClick (movieItem: MovieItem, position: Int)
        fun onFavoriteClick (movieItem: MovieItem, position: Int)
    }*/

        }
    }
}