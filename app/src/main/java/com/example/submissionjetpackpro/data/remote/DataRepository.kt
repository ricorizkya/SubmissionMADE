package com.example.submissionjetpackpro.data.remote

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.submissionjetpackpro.data.local.GetLocalDataSource
import com.example.submissionjetpackpro.data.local.model.MoviesEntity
import com.example.submissionjetpackpro.data.local.model.TVShowsEntity
import com.example.submissionjetpackpro.data.remote.movies.MoviesDataResponse
import com.example.submissionjetpackpro.data.remote.tvshows.TVShowsDataResponse
import com.example.submissionjetpackpro.vo.Resources

class DataRepository private constructor(
        private val dataSource: DataSource,
        private val getLocalDataSource: GetLocalDataSource,
        private val appExecutors: AppExecutors): GetDataSource {

    companion object {
        @Volatile
        private var dataRepository: DataRepository? = null

        fun getInstance(
            remote: DataSource,
            local: GetLocalDataSource,
            appExecutors: AppExecutors): DataRepository =
                dataRepository ?: synchronized(this) {
                    DataRepository(remote, local, appExecutors).apply {
                        dataRepository = this
                    }
                }
    }

    /**MOVIES**/
    override fun movies(): LiveData<Resources<List<MoviesEntity>>> {
        return object : NetworkBoundResources<List<MoviesEntity>, List<MoviesDataResponse>>(appExecutors) {
            override fun loadDB(): LiveData<List<MoviesEntity>> {
                return getLocalDataSource.getMovies()
            }

            override fun fetch(resultType: List<MoviesEntity>?): Boolean {
                return resultType == null || resultType.isEmpty()
            }

            override fun apiCall(): LiveData<ApiResponse<List<MoviesDataResponse>>> {
                return dataSource.getMovies()
            }

            override fun callResult(requestType: List<MoviesDataResponse>?) {
                val movies = ArrayList<MoviesEntity>()
                if (requestType != null) {
                    for (movieResponse in requestType) {
                        lateinit var dataMoviesEntity: MoviesEntity
                        movieResponse.apply {
                            dataMoviesEntity = MoviesEntity(id, title, description,timeRelease, rating, imgPhoto, false)
                            movies.add(dataMoviesEntity)
                        }
                    }
                    getLocalDataSource.insertMovies(movies)
                }
            }
        }.asLiveData()
    }

    override fun moviesDetail(moviesId: Int): LiveData<Resources<MoviesEntity>> {
        return object : NetworkBoundResources<MoviesEntity, MoviesDataResponse>(appExecutors) {
            override fun loadDB(): LiveData<MoviesEntity> {
                return getLocalDataSource.getMoviesDetail(moviesId)
            }

            override fun fetch(resultType: MoviesEntity?): Boolean {
                return resultType == null
            }

            override fun apiCall(): LiveData<ApiResponse<MoviesDataResponse>> {
                return dataSource.getMoviesDetail(moviesId)
            }

            override fun callResult(requestType: MoviesDataResponse?) { }
        }.asLiveData()
    }

    override fun moviesInsert(moviesEntity: List<MoviesEntity>) {
        val insert = {
            if (getLocalDataSource.getMovies().value.isNullOrEmpty()) {
                getLocalDataSource.insertMovies(moviesEntity)
            }
        }
        appExecutors.diskIO().execute(insert)
    }

    override fun setMoviesFavorite(moviesEntity: MoviesEntity, favorite: Boolean) {
        return appExecutors.diskIO().execute {
            getLocalDataSource.setMoviesFavorite(moviesEntity, favorite)
        }
    }

    override fun getMoviesFavorite(): LiveData<PagedList<MoviesEntity>> {
        val getDataFavorite = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(20)
            .build()
        return LivePagedListBuilder(getLocalDataSource.getMoviesFavorite(), getDataFavorite).build()
    }


    /**TV SHOWS**/
    override fun tvShows(): LiveData<Resources<List<TVShowsEntity>>> {
        return object : NetworkBoundResources<List<TVShowsEntity>, List<TVShowsDataResponse>>(appExecutors) {
            override fun loadDB(): LiveData<List<TVShowsEntity>> {
                return getLocalDataSource.getTVShows()
            }

            override fun fetch(resultType: List<TVShowsEntity>?): Boolean {
                return resultType == null || resultType.isEmpty()
            }

            override fun apiCall(): LiveData<ApiResponse<List<TVShowsDataResponse>>> {
                return dataSource.getTVShows()
            }

            override fun callResult(requestType: List<TVShowsDataResponse>?) {
                val tvShows = ArrayList<TVShowsEntity>()
                if (requestType != null) {
                    for (tvShowsResponse in requestType) {
                        lateinit var tvShowsEntity: TVShowsEntity
                        tvShowsResponse.apply {
                            tvShowsEntity = TVShowsEntity(id, title, description, timeRelease, rating, imgPhoto, false)
                            tvShows.add(tvShowsEntity)
                        }
                    }
                    getLocalDataSource.insertTVShows(tvShows)
                }
            }
        }.asLiveData()
    }

    override fun tvShowsDetail(tvShowsId: Int): LiveData<Resources<TVShowsEntity>> {
        return object : NetworkBoundResources<TVShowsEntity, TVShowsDataResponse>(appExecutors) {
            override fun loadDB(): LiveData<TVShowsEntity> {
                return getLocalDataSource.getTVShowsDetail(tvShowsId)
            }

            override fun fetch(resultType: TVShowsEntity?): Boolean {
                return resultType == null
            }

            override fun apiCall(): LiveData<ApiResponse<TVShowsDataResponse>> {
                return dataSource.getTVShowsDetail(tvShowsId)
            }

            override fun callResult(requestType: TVShowsDataResponse?) {}
        }.asLiveData()
    }

    override fun tvShowsInsert(tvShowsEntity: List<TVShowsEntity>) {
        val insert = {
            if (getLocalDataSource.getTVShows().value.isNullOrEmpty()) {
                getLocalDataSource.insertTVShows(tvShowsEntity)
            }
        }
        appExecutors.diskIO().execute(insert)
    }

    override fun setTVShowsFavorite(tvShowsEntity: TVShowsEntity, favorite: Boolean) {
        appExecutors.diskIO().execute {
            getLocalDataSource.setTVShowsFavorite(tvShowsEntity, favorite)
        }
    }

    override fun getTVShowsFavorite(): LiveData<PagedList<TVShowsEntity>> {
        val getDataFavorite = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(20)
            .build()
        return LivePagedListBuilder(getLocalDataSource.getTVShowsFavorite(), getDataFavorite).build()
    }
}