package com.example.themovies.model

import com.google.gson.annotations.SerializedName

data class Movies (
    val id:String,
    val title:String,
    val overview:String,

    @SerializedName("poster_path")
    var posterPath : String,

    @SerializedName("backdrop_path")
    var backdropPath : String
)

