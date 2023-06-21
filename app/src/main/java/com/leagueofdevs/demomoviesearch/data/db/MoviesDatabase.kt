package com.leagueofdevs.demomoviesearch.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.leagueofdevs.demomoviesearch.data.FavoriteMovieDao
import com.leagueofdevs.demomoviesearch.data.FavoriteMovieEntity

@Database(entities = [FavoriteMovieEntity::class], version = 1, exportSchema = false)
abstract class MoviesDatabase : RoomDatabase() {
    abstract fun movieDao(): FavoriteMovieDao

}
