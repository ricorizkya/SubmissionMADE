package com.example.submissionjetpackpro.data.remote.genre

import com.google.gson.annotations.SerializedName

data class GenreResponse(

    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String

)
