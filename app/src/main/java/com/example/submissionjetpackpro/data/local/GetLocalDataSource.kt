package com.example.submissionjetpackpro.data.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.example.submissionjetpackpro.data.local.database.DAO
import com.example.submissionjetpackpro.data.local.model.MoviesEntity
import com.example.submissionjetpackpro.data.local.model.TVShowsEntity

class GetLocalDataSource
    private constructor(private val dao: DAO) {

        companion object {
            private var DATA: GetLocalDataSource? = null
            fun getInstance(dao: DAO): GetLocalDataSource =
                DATA ?: GetLocalDataSource(dao)
        }

    /**MOVIES**/
    fun getMovies(): LiveData<List<MoviesEntity>> = dao.getMovies()
    fun getMoviesDetail(moviesId: Int): LiveData<MoviesEntity> = dao.getMoviesDetail(moviesId)
    fun insertMovies(moviesEntity: List<MoviesEntity>) = dao.insertMovies(moviesEntity)
    fun getMoviesFavorite(): DataSource.Factory<Int, MoviesEntity> = dao.getMoviesFavorite()
    fun setMoviesFavorite(moviesEntity: MoviesEntity, favorite: Boolean) {
        moviesEntity.favorite = favorite
        dao.updateMovies(moviesEntity)
    }

    /**TV SHOWS**/
    fun getTVShows(): LiveData<List<TVShowsEntity>> = dao.getTVShows()
    fun getTVShowsDetail(tvShowsId: Int): LiveData<TVShowsEntity> = dao.getTVShowsDetail(tvShowsId)
    fun insertTVShows(tvShowsEntity: List<TVShowsEntity>) = dao.insertTVShows(tvShowsEntity)
    fun getTVShowsFavorite(): DataSource.Factory<Int, TVShowsEntity> = dao.getTVShowsFavorite()
    fun setTVShowsFavorite(tvShowsEntity: TVShowsEntity, favorite: Boolean) {
        tvShowsEntity.favorite = favorite
        dao.updateTVShows(tvShowsEntity)
    }
}