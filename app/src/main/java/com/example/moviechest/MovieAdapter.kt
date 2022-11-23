package com.example.moviechest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.ListAdapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class MovieAdapter
    (
    private val movies: ArrayList<MovieItem>,
    val listener: MoviesClicklistener
) :
   //ListAdapter<MovieAdapter.MovieViewHolder>(MovieItemDiffCallBack()){
    RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
// вместо RV.Adapter должно  быть наследование от ListAdapter(DiffCallback()), но выдает ошибку

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MovieViewHolder(inflater.inflate(R.layout.item_movie, parent, false))
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movies[position], listener)
    }

    override fun getItemCount(): Int = movies.size

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleText: TextView = itemView.findViewById(R.id.textViewItem)
        val pictureImage: ImageView = itemView.findViewById(R.id.imageViewItem)
        val buttonDetails: Button = itemView.findViewById(R.id.buttonItem)

        fun bind(item: MovieItem, listener: MoviesClicklistener) {
            titleText.text = item.title
            buttonDetails.text = item.button
            pictureImage.setImageResource(item.imageId)
            pictureImage.setOnClickListener {
listener.onFavoriteClick(item)
            }
            buttonDetails.setOnClickListener {
listener.onMoviesClick(item)
            }
        }
    }
    interface MoviesClicklistener {
        fun onMoviesClick(item: MovieItem)
        fun onFavoriteClick(item: MovieItem)
    }
}
