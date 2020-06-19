package com.gsixacademy.android.mymovies.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.gsixacademy.android.mymovies.R
import com.gsixacademy.android.mymovies.api.ApiServiceBuilder
import com.gsixacademy.android.mymovies.api.MovieDatabaseApi
import com.gsixacademy.android.mymovies.models.MovieListResponse
import kotlinx.android.synthetic.main.movies_list_fragment.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MoviesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        val view = inflater.inflate(R.layout.movies_list_fragment, container, false)

        val request = ApiServiceBuilder.buildService(MovieDatabaseApi::class.java)

        val category = arguments?.getString("category")
        val call = request.getMovies(category, 1)

        call.enqueue(object : Callback<MovieListResponse> {
            override fun onFailure(call: Call<MovieListResponse>, t: Throwable) {
                Toast.makeText(activity, "Error", Toast.LENGTH_SHORT).show()

            }

            override fun onResponse(
                call: Call<MovieListResponse>, response: Response<MovieListResponse>
            ) {
                if (response.isSuccessful) {
                    var movieResponse = response.body()
                    var movieList = movieResponse?.results
                    if (movieList != null) {
                        var movieListAdapter = MovieListAdapter(movieList) {
                            if (it is MoviesOnClickEvent.onMovieClicked) {
                                Toast.makeText(activity, "Title : " + it.movie.title, Toast.LENGTH_SHORT).show()
                            }
                        }
                        recycler_view_movies.layoutManager = GridLayoutManager(context,2)
                        recycler_view_movies.adapter = movieListAdapter
                    }
                }

            }

        })

        return view

    }
}
