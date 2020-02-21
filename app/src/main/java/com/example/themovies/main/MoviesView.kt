package com.example.themovies.main

import com.example.themovies.model.Movies

interface MoviesView {
    fun showMovieList(movieData:List<Movies>)
}