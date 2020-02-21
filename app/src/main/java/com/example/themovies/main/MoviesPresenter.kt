package com.example.themovies.main

import com.example.themovies.model.MoviesResponse
import com.example.themovies.network.TMDBApiRepository
import com.example.themovies.network.TMDBApi
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread


class MoviesPresenter (private val movieview:MoviesView, private val apiRepository:TMDBApiRepository){
    fun getMovieList(){
        doAsync{
            val data=Gson().fromJson(apiRepository.makeRequest(TMDBApi.getMovie()),MoviesResponse::class.java)

            uiThread{
                movieview.showMovieList(data.results)
            }
        }
    }
}