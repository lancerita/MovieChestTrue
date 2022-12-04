package com.example.moviechest

import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviechest.databinding.FragmentMoviesBinding

class MoviesFragment : Fragment() {

    private var movies = MoviesStorage.getAllMovies()
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

            movies = if (!isFavourite) {
                MoviesStorage.getAllMovies()
            } else {
                MoviesStorage.getFavoriteMovies()
            }
            if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
                recycler.layoutManager = GridLayoutManager(context, 2)
            } else {
                recycler.layoutManager = LinearLayoutManager(context)
            }
            val listener = object : MovieAdapter.MoviesClicklistener {

                override fun onMoviesClick(movie: MovieItem) {
                    val intent = MovieActivity.getIntent(requireContext(), movie)
                    startActivity(intent)
                    Log.d("smth", "open activity")
                }

                override fun onFavoriteClick(item: MovieItem, position: Int) {
                    Toast.makeText(activity, "Favorite Click", Toast.LENGTH_SHORT).show()
                    val newItem = movies[position].copy(isFavorites = true)
                    movies = movies.toMutableList().apply {
                        set(position, item)
                    }
                    MoviesStorage.updateItem(position, newItem)
                    val adapter = recycler.adapter as? MovieAdapter ?: return
                    adapter.updateMovieList(movies)
                    //adapter.updateMoviesList().submitList(MoviesStorage.getAllMovies())
                }
            }
            recycler.adapter = MovieAdapter(listener).apply {
                updateMovieList(movies)
            }

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

