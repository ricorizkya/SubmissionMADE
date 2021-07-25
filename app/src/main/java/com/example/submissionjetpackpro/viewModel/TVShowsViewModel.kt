package com.example.submissionjetpackpro.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.submissionjetpackpro.data.local.model.TVShowsEntity
import com.example.submissionjetpackpro.data.remote.DataRepository
import com.example.submissionjetpackpro.vo.Resources

class TVShowsViewModel(private val dataRepository: DataRepository): ViewModel() {

    fun getTVShows(): LiveData<Resources<List<TVShowsEntity>>> = dataRepository.tvShows()
}