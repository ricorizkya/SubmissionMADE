package com.example.submissionjetpackpro.activity

import com.example.submissionjetpackpro.model.TVShows

interface TVShowsFragmentCallback {

    fun onItemClick(tvShows: TVShows)
}