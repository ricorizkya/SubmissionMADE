package com.example.submissionjetpackpro.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.submissionjetpackpro.data.remote.DataRepository
import com.example.submissionjetpackpro.utils.Injection

class ViewModelFactory private constructor(private val dataRepository: DataRepository): ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var viewModelFactory: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
            viewModelFactory ?: ViewModelFactory(Injection.provideRepository(context)).apply {
                viewModelFactory = this
            }
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MoviesViewModel::class.java) -> {
                MoviesViewModel(dataRepository) as T
            }
            modelClass.isAssignableFrom(DetailMoviesViewModel::class.java) -> {
                DetailMoviesViewModel(dataRepository) as T
            }
            modelClass.isAssignableFrom(FavoriteMoviesViewModel::class.java) -> {
                FavoriteMoviesViewModel(dataRepository) as T
            }
            modelClass.isAssignableFrom(TVShowsViewModel::class.java) -> {
                TVShowsViewModel(dataRepository) as T
            }
            modelClass.isAssignableFrom(DetailTVShowsViewModel::class.java) -> {
                DetailTVShowsViewModel(dataRepository) as T
            }
            modelClass.isAssignableFrom(FavoriteTVShowsViewModel::class.java) -> {
                FavoriteTVShowsViewModel(dataRepository) as T
            }else -> throw Throwable("Error: "+modelClass.name)
        }
    }
}