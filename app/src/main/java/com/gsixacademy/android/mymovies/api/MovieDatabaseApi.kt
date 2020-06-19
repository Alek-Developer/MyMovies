package com.gsixacademy.android.mymovies.api

import com.gsixacademy.android.mymovies.models.MovieListResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

const val apiKey = "api_key=1eed6e080da37ad7833cd91f74618139"

interface MovieDatabaseApi {

    @GET("movie/{category}?" + apiKey)
    fun getMovies(@Path("category") category: String?, @Query("page") page: Int): Call<MovieListResponse>
}