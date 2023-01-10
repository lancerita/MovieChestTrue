package com.example.moviechest.presentation

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
import com.example.moviechest.domain.MovieAdapter
import com.example.moviechest.data.MovieItem
import com.example.moviechest.data.MoviesStorageCurrent
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
                MoviesStorageCurrent.getFavoriteMovies()
            } else {
                MoviesStorageCurrent.getAllMovies()
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
                   // (recycler.adapter as MovieAdapter).updateMovie(item)
                    if (isFavourite) {
                        val adapter = recycler.adapter as? MovieAdapter ?: return
                        movies[position].isFavorites = false
                        adapter.removeItem(position)
                    } else {
                        movies[position].isFavorites = !item.isFavorites
                        recycler.adapter?.notifyItemChanged(position)
                    }
                }
            }
            recycler.adapter = MovieAdapter(movies.toMutableList(), listener)
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

