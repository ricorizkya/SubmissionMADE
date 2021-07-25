package com.example.submissionjetpackpro.data.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.example.submissionjetpackpro.vo.Resources

abstract class NetworkBoundResources<ResultType, RequestType>(private val appExecutors: AppExecutors) {

    private val mediatorLiveData = MediatorLiveData<Resources<ResultType>>()
    init {
        mediatorLiveData.value = Resources.loading(null)
        @Suppress("LeakingThis")
        val db = loadDB()
        mediatorLiveData.addSource(db) {
            data -> mediatorLiveData.removeSource(db)
            if (fetch(data)) {
                fetchNetwork(db)
            }else {
                mediatorLiveData.addSource(db) {
                    newData -> mediatorLiveData.value = Resources.success(newData)
                }
            }
        }
    }

    private fun fetchFailed(){}
    private fun fetchNetwork(db: LiveData<ResultType>){
        val apiResponse = apiCall()
        mediatorLiveData.addSource(db) {
            newData -> mediatorLiveData.value = Resources.loading(newData)
        }
        mediatorLiveData.addSource(apiResponse){ respone ->
            mediatorLiveData.removeSource(apiResponse)
            mediatorLiveData.removeSource(db)
            when (respone.statusResponse) {
                StatusResponse.SUCCESS ->
                    appExecutors.diskIO().execute {
                        callResult(respone.body)
                        appExecutors.mainThread().execute {
                            mediatorLiveData.addSource(loadDB()) {
                                newData -> mediatorLiveData.value = Resources.success(newData)
                            }
                        }
                    }
                StatusResponse.ERROR -> {
                    fetchFailed()
                    mediatorLiveData.addSource(db) {
                        newData -> mediatorLiveData.value = Resources.error(respone.message, newData)
                    }
                }
            }
        }
    }

    fun asLiveData(): LiveData<Resources<ResultType>> = mediatorLiveData
    protected abstract fun loadDB(): LiveData<ResultType>
    protected abstract fun fetch(resultType: ResultType?): Boolean
    protected abstract fun apiCall(): LiveData<ApiResponse<RequestType>>
    protected abstract fun callResult(requestType: RequestType?)
}