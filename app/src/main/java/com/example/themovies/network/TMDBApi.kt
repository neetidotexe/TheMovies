package com.example.themovies.network

import com.example.themovies.BuildConfig.API_KEY
import com.example.themovies.BuildConfig.BASE_URL

object TMDBApi {
    fun getMovie():String{
        return BASE_URL + API_KEY
    }


}