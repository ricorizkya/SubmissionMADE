package com.example.submissionjetpackpro.activity

import com.example.submissionjetpackpro.data.local.model.MoviesEntity
import com.example.submissionjetpackpro.model.Movies

interface MoviesFragmentCallback {

    fun onItem(id: String)
}