package com.gsixacademy.android.mymovies.home

import com.gsixacademy.android.mymovies.models.MovieResults

sealed class MoviesOnClickEvent {
    data class onMovieClicked(val movie: MovieResults) : MoviesOnClickEvent()
}