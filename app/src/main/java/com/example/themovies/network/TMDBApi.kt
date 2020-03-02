package com.example.themovies.network

import com.example.themovies.BuildConfig.*

object TMDBApi {
    fun getTopRatedMovie():String{
        return BASE_URL_TOP_RATED + API_KEY
    }

    fun getPopulardMovie():String{
        return BASE_URL_POPULAR + API_KEY
    }

}