package com.example.submissionjetpackpro.data.remote.movies

import com.example.submissionjetpackpro.data.remote.genre.GenreResponse
import com.google.gson.annotations.SerializedName

data class Movies (

    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("overview")
    val description: String,
    @SerializedName("release_date")
    val timeRelease: String,
    @SerializedName("vote_average")
    val rating: String,
    @SerializedName("poster_path")
    val imgPhoto: String

)