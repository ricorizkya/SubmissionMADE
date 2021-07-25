package com.example.submissionjetpackpro.utils

import android.content.Context
import com.example.submissionjetpackpro.data.local.GetLocalDataSource
import com.example.submissionjetpackpro.data.local.database.Databases
import com.example.submissionjetpackpro.data.remote.AppExecutors
import com.example.submissionjetpackpro.data.remote.DataRepository
import com.example.submissionjetpackpro.data.remote.DataSource

object Injection {

    fun provideRepository(context: Context): DataRepository {
        val dataSource = DataSource.getInstance()
        val database = Databases.getInstance(context)
        val localDataSource = GetLocalDataSource.getInstance(database.DAO())
        val appExecutors = AppExecutors()
        return DataRepository.getInstance(dataSource, localDataSource, appExecutors)
    }

}