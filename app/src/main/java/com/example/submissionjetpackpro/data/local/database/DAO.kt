package com.example.submissionjetpackpro.data.local.database

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.example.submissionjetpackpro.data.local.model.MoviesEntity
import com.example.submissionjetpackpro.data.local.model.TVShowsEntity

@Dao
interface DAO {

    /**MOVIES**/
    @Query("SELECT * FROM tb_movies")
    fun getMovies(): LiveData<List<MoviesEntity>>

//    @Transaction
    @Query("SELECT * FROM tb_movies WHERE id = :moviesId")
    fun getMoviesDetail(moviesId: Int): LiveData<MoviesEntity>

    @Query("SELECT * FROM tb_movies WHERE favorite = 1")
    fun getMoviesFavorite(): DataSource.Factory<Int, MoviesEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovies(moviesEntity: List<MoviesEntity>)

    @Update
    fun updateMovies(moviesEntity: MoviesEntity)

    /**TV SHOWS**/
    @Query("SELECT * FROM tb_tvShows")
    fun getTVShows(): LiveData<List<TVShowsEntity>>

//    @Transaction
    @Query("SELECT * FROM tb_tvShows WHERE id = :tvShowsId")
    fun getTVShowsDetail(tvShowsId: Int): LiveData<TVShowsEntity>

    @Query("SELECT * FROM tb_tvShows WHERE favorite = 1")
    fun getTVShowsFavorite(): DataSource.Factory<Int, TVShowsEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTVShows(tvShowsEntity: List<TVShowsEntity>)

    @Update
    fun updateTVShows(tvShowsEntity: TVShowsEntity)

}