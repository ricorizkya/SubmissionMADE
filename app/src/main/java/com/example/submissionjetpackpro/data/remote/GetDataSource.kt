package com.example.submissionjetpackpro.data.remote

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.example.submissionjetpackpro.data.local.model.MoviesEntity
import com.example.submissionjetpackpro.data.local.model.TVShowsEntity
import com.example.submissionjetpackpro.vo.Resources

interface GetDataSource {

    /**MOVIES**/
    fun movies(): LiveData<Resources<List<MoviesEntity>>>
    fun moviesDetail(moviesId: Int): LiveData<Resources<MoviesEntity>>
    fun moviesInsert(moviesEntity: List<MoviesEntity>)
    fun setMoviesFavorite(moviesEntity: MoviesEntity, favorite: Boolean)
    fun getMoviesFavorite(): LiveData<PagedList<MoviesEntity>>

    /**TV SHOWS**/
    fun tvShows(): LiveData<Resources<List<TVShowsEntity>>>
    fun tvShowsDetail(tvShowsId: Int): LiveData<Resources<TVShowsEntity>>
    fun tvShowsInsert(tvShowsEntity: List<TVShowsEntity>)
    fun setTVShowsFavorite(tvShowsEntity: TVShowsEntity, favorite: Boolean)
    fun getTVShowsFavorite(): LiveData<PagedList<TVShowsEntity>>

}