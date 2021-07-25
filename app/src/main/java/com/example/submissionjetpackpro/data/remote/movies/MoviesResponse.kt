package com.example.submissionjetpackpro.data.remote.movies

import com.google.gson.annotations.SerializedName

data class MoviesResponse (

    @SerializedName("results")
    val listMovie: List<MoviesDataResponse>

)