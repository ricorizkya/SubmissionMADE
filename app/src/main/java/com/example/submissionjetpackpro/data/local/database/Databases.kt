package com.example.submissionjetpackpro.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import com.example.submissionjetpackpro.data.local.model.MoviesEntity
import com.example.submissionjetpackpro.data.local.model.TVShowsEntity

@Database(entities = [MoviesEntity::class, TVShowsEntity::class], version = 1, exportSchema = false)
abstract class Databases: RoomDatabase() {

    abstract fun DAO(): DAO
    companion object {
        @Volatile
        private var DATABASE: Databases ?= null
        fun getInstance(context: Context): Databases =
            DATABASE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    Databases::class.java,
                    "netflix"
                ).build().apply {
                    DATABASE = this
                }
            }
    }
}