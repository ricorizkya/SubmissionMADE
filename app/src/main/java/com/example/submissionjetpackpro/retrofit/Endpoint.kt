package com.example.submissionjetpackpro.retrofit

import com.example.submissionjetpackpro.data.remote.movies.MoviesDataResponse
import com.example.submissionjetpackpro.data.remote.movies.MoviesResponse
import com.example.submissionjetpackpro.data.remote.tvshows.TVShowsDataResponse
import com.example.submissionjetpackpro.data.remote.tvshows.TVShowsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Endpoint {

    companion object {
        const val API_KEY = "4243d3b293cb75eba91f309e62952dc3"
    }

    @GET("movie/popular?api_key=$API_KEY")
    fun getListMovies(
        @Query("page") page: Int
    ): Call<MoviesResponse>

    @GET("movie/{movie_id}?api_key=$API_KEY")
    fun getDetailMovies(
        @Path("movie_id") movieId: Int
    ): Call<MoviesDataResponse>

    @GET("tv/popular?api_key=$API_KEY")
    fun getListTVShows(
        @Query("page") page: Int
    ): Call<TVShowsResponse>

    @GET("tv/{tv_id}?api_key=$API_KEY")
    fun getDetailTVShows(
        @Path("tv_id") tvShowsId: Int
    ): Call<TVShowsDataResponse>
}