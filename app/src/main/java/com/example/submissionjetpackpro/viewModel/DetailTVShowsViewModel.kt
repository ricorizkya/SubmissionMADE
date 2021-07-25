package com.example.submissionjetpackpro.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.submissionjetpackpro.data.local.model.TVShowsEntity
import com.example.submissionjetpackpro.data.remote.DataRepository
import com.example.submissionjetpackpro.vo.Resources

class DetailTVShowsViewModel(private val dataRepository: DataRepository): ViewModel() {

    var tvShowsId = MutableLiveData<Int>()
    var getTVShowsDetail: LiveData<Resources<TVShowsEntity>> = Transformations.switchMap(tvShowsId) {
        dataRepository.tvShowsDetail(it)
    }

    fun setTVShowsDetail(tvShowsId: Int) {
        this.tvShowsId.value = tvShowsId
    }

    fun setFavorite() {
        val favorite = getTVShowsDetail.value
        if (favorite != null) {
            val tvSHowsFavorite = favorite.data
            if (tvSHowsFavorite != null) {
                val state = !tvSHowsFavorite.favorite
                dataRepository.setTVShowsFavorite(tvSHowsFavorite, state)
            }
        }
    }
}