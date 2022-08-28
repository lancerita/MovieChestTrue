package com.example.moviechest

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val title: TextView = itemView.findViewById(R.id.textViewItem)
    val image: ImageView = itemView.findViewById(R.id.imageViewItem)
    val button: TextView = itemView.findViewById(R.id.buttonItem)

    fun bind(item: MovieItem) {
        title.text = item.title
        button.text = item.button
        image.setImageResource(item.imageId)
       /* image.setOnClickListener {
            listener.onFavoriteClick(item, adapterPosition)
        }
        button.setOnClickListener {
        listener.onMoviesClick(item, adapterPosition)
    }*/
    }


}