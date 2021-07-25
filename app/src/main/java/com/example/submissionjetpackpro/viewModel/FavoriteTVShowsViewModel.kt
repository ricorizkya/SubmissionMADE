package com.example.submissionjetpackpro.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.example.submissionjetpackpro.data.local.model.TVShowsEntity
import com.example.submissionjetpackpro.data.remote.DataRepository

class FavoriteTVShowsViewModel(private val dataRepository: DataRepository): ViewModel() {

    fun favoriteTVShows(): LiveData<PagedList<TVShowsEntity>> = dataRepository.getTVShowsFavorite()

}