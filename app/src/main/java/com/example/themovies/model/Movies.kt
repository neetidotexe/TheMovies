package com.example.themovies.model

import android.icu.math.BigDecimal
import com.google.gson.annotations.SerializedName

data class Movies (
    val id:String,
    val title:String,
    val overview:String,
    val release_date:String,
    val vote_average: String,

    @SerializedName("poster_path")
    var posterPath : String,

    @SerializedName("backdrop_path")
    var backdropPath : String
)

