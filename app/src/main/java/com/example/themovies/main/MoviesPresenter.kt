package com.example.themovies.main

import com.example.themovies.model.MoviesResponse
import com.example.themovies.network.TMDBApiRepository
import com.example.themovies.network.TMDBApi
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread


class MoviesPresenter (private val movieview:MoviesView, private val apiRepository:TMDBApiRepository){
    fun getTopRatedMovieList(){
        doAsync{
            val topRatedMovieData=Gson().fromJson(apiRepository.makeRequest(TMDBApi.getTopRatedMovie()),MoviesResponse::class.java)

            uiThread{
                movieview.showMovieList(topRatedMovieData.results)
            }
        }
    }

    fun getPopularMovieList()
    {
        doAsync{
            val popularMovieData=Gson().fromJson(apiRepository.makeRequest(TMDBApi.getPopulardMovie()),MoviesResponse::class.java)

            uiThread{
                movieview.showMovieList(popularMovieData.results)
            }
        }
    }
}