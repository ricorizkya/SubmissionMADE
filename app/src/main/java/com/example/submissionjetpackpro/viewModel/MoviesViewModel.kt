package com.example.submissionjetpackpro.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.submissionjetpackpro.data.local.model.MoviesEntity
import com.example.submissionjetpackpro.data.remote.DataRepository
import com.example.submissionjetpackpro.vo.Resources

class MoviesViewModel(private val dataRepository: DataRepository): ViewModel() {

    fun getMovies(): LiveData<Resources<List<MoviesEntity>>> = dataRepository.movies()
}