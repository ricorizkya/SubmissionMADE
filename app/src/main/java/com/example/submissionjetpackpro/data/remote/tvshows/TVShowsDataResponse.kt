package com.example.submissionjetpackpro.data.remote.tvshows

import com.example.submissionjetpackpro.data.remote.genre.GenreResponse
import com.google.gson.annotations.SerializedName

data class TVShowsDataResponse (

        @SerializedName("id")
        val id: Int,
        @SerializedName("name")
        val title: String,
        @SerializedName("overview")
        val description: String,
        @SerializedName("genres")
        val genre: List<GenreResponse>,
        @SerializedName("first_air_date")
        val timeRelease: String,
        @SerializedName("vote_average")
        val rating: String,
        @SerializedName("poster_path")
        val imgPhoto: String

)
