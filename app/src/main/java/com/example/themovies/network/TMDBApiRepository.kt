package com.example.themovies.network

import java.net.URL

class TMDBApiRepository {
    fun makeRequest(url:String):String{
        return URL(url).readText()
    }
}