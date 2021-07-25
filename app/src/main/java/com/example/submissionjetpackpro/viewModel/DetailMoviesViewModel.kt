package com.example.submissionjetpackpro.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.submissionjetpackpro.data.local.model.MoviesEntity
import com.example.submissionjetpackpro.data.local.model.TVShowsEntity
import com.example.submissionjetpackpro.data.remote.DataRepository
import com.example.submissionjetpackpro.vo.Resources

class DetailMoviesViewModel(private val dataRepository: DataRepository): ViewModel() {

    var moviesId = MutableLiveData<Int>()
    var getMoviesDetail: LiveData<Resources<MoviesEntity>> = Transformations.switchMap(moviesId) {
        dataRepository.moviesDetail(it)
    }

    fun setMoviesDetail(moviesId: Int) {
        this.moviesId.value = moviesId
    }

    fun setFavorite() {
        val favorite = getMoviesDetail.value
        if (favorite != null) {
            val moviesFavorite = favorite.data
            if (moviesFavorite != null) {
                val state = !moviesFavorite.favorite
                dataRepository.setMoviesFavorite(moviesFavorite, state)
            }
        }
    }
}