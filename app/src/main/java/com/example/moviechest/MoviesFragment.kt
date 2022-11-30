package com.example.moviechest

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviechest.databinding.FragmentMoviesBinding

class MoviesFragment : Fragment() {

    private val isFavourite: Boolean by lazy { requireArguments().getBoolean(ARG_IS_FAVOURITE) }

    private lateinit var binding: FragmentMoviesBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMoviesBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.apply {
            val movies = if (isFavourite) {
                MoviesStorage.getFavoriteMovies()
            } else {
                MoviesStorage.getAllMovies()
            }
            recycler.layoutManager = LinearLayoutManager(context)
            val listener = object : MovieAdapter.MoviesClicklistener {

                override fun onMoviesClick(movie: MovieItem) {
                        val intent = Intent(activity, MovieActivity::class.java)
                        intent.putExtra("OPEN_MOVIE", movie)
                        startActivity(intent)
                        Log.d("smth", "open activity")
                }

                override fun onFavoriteClick(item: MovieItem, position: Int) {
                    Toast.makeText(activity, "Favorite Click", Toast.LENGTH_SHORT).show()
                   // item.isfavorites = !item.isfavorites
                    //(recycler.adapter as MovieAdapter).updateMovie(item)
                    movies[position].isfavorites = !item.isfavorites
                    recycler.adapter?.notifyItemChanged(position)
                }
            }
            recycler.adapter = MovieAdapter(movies, listener)
        }
    }

    companion object {

        private const val ARG_IS_FAVOURITE = "is_favourite_key"

        fun newInstance(
            isFavourite: Boolean
        ): MoviesFragment {
            return MoviesFragment().apply {
                arguments = bundleOf(
                    ARG_IS_FAVOURITE to isFavourite
                )
            }
        }
    }
}

