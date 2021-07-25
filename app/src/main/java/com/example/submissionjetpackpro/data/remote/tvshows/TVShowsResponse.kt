package com.example.submissionjetpackpro.data.remote.tvshows

import com.google.gson.annotations.SerializedName

data class TVShowsResponse(

    @SerializedName("results")
    val listTVShows: List<TVShowsDataResponse>
)
