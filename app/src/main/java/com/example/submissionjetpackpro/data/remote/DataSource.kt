package com.example.submissionjetpackpro.data.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.submissionjetpackpro.data.remote.movies.MoviesDataResponse
import com.example.submissionjetpackpro.data.remote.movies.MoviesResponse
import com.example.submissionjetpackpro.data.remote.tvshows.TVShowsDataResponse
import com.example.submissionjetpackpro.data.remote.tvshows.TVShowsResponse
import com.example.submissionjetpackpro.retrofit.Client
import com.example.submissionjetpackpro.utils.EspressoIdlingResource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DataSource {

    companion object {
        @Volatile
        private var dataSource: DataSource? = null
        fun getInstance(): DataSource = dataSource ?: synchronized(this) {
            dataSource ?: DataSource()
        }
    }

    fun getMovies(): LiveData<ApiResponse<List<MoviesDataResponse>>> {
        EspressoIdlingResource.increment()
        val movies = MutableLiveData<ApiResponse<List<MoviesDataResponse>>>()
        Client.retrofitService().getListMovies(1)
                .enqueue(object : Callback<MoviesResponse> {
                    override fun onResponse(call: Call<MoviesResponse>, response: Response<MoviesResponse>) {
                        movies.value = ApiResponse.success(response.body()?.listMovie)
                        EspressoIdlingResource.decrement()
                    }

                    override fun onFailure(call: Call<MoviesResponse>, t: Throwable) {
                        Log.d("TAG", "Error: ${t.message}")
                        EspressoIdlingResource.decrement()
                    }

                })
        return movies
    }

    fun getMoviesDetail(moviesId: Int): LiveData<ApiResponse<MoviesDataResponse>> {
        EspressoIdlingResource.increment()
        val moviesDetail = MutableLiveData<ApiResponse<MoviesDataResponse>>()
        Client.retrofitService().getDetailMovies(moviesId)
                .enqueue(object : Callback<MoviesDataResponse> {
                    override fun onResponse(call: Call<MoviesDataResponse>, response: Response<MoviesDataResponse>) {
                        moviesDetail.value = ApiResponse.success(response.body())
                        EspressoIdlingResource.decrement()
                    }

                    override fun onFailure(call: Call<MoviesDataResponse>, t: Throwable) {
                        Log.d("TAG", "Error: ${t.message}")
                        EspressoIdlingResource.decrement()
                    }

                })
        return moviesDetail
    }

    fun getTVShows(): LiveData<ApiResponse<List<TVShowsDataResponse>>> {
        EspressoIdlingResource.increment()
        val tvShows = MutableLiveData<ApiResponse<List<TVShowsDataResponse>>>()
        Client.retrofitService().getListTVShows(1)
                .enqueue(object : Callback<TVShowsResponse> {
                    override fun onResponse(call: Call<TVShowsResponse>, response: Response<TVShowsResponse>) {
                        tvShows.value = ApiResponse.success(response.body()?.listTVShows)
                        EspressoIdlingResource.decrement()
                    }

                    override fun onFailure(call: Call<TVShowsResponse>, t: Throwable) {
                        Log.d("TAG", "Error: ${t.message}")
                        EspressoIdlingResource.decrement()
                    }

                })
        return tvShows
    }

    fun getTVShowsDetail(tvShowsId: Int): LiveData<ApiResponse<TVShowsDataResponse>> {
        EspressoIdlingResource.increment()
        val tvShowsDetail = MutableLiveData<ApiResponse<TVShowsDataResponse>>()
        Client.retrofitService().getDetailTVShows(tvShowsId)
                .enqueue(object : Callback<TVShowsDataResponse> {
                    override fun onResponse(call: Call<TVShowsDataResponse>, response: Response<TVShowsDataResponse>) {
                        tvShowsDetail.value = ApiResponse.success(response.body())
                        EspressoIdlingResource.decrement()
                    }

                    override fun onFailure(call: Call<TVShowsDataResponse>, t: Throwable) {
                        Log.d("TAG", "Error: ${t.message}")
                        EspressoIdlingResource.decrement()
                    }
                })
        return tvShowsDetail
    }
}