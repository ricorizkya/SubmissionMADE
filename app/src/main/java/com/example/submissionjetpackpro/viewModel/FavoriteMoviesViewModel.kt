package com.example.submissionjetpackpro.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.example.submissionjetpackpro.data.local.model.MoviesEntity
import com.example.submissionjetpackpro.data.remote.DataRepository

class FavoriteMoviesViewModel(private val dataRepository: DataRepository): ViewModel() {

    fun favoriteMovies(): LiveData<PagedList<MoviesEntity>> = dataRepository.getMoviesFavorite()

}