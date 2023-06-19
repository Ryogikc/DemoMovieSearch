package com.leagueofdevs.demomoviesearch.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.leagueofdevs.demomoviesearch.data.FavoriteMovieEntity
import com.leagueofdevs.demomoviesearch.data.FavoriteMovieDao

@Database(entities = [FavoriteMovieEntity::class], version = 1, exportSchema = false)
abstract class MoviesDatabase : RoomDatabase(){
    abstract fun movieDao(): FavoriteMovieDao

    companion object {
        @Volatile
        private var INSTANCE: MoviesDatabase? = null

        fun getInstance(context: Context): MoviesDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MoviesDatabase::class.java,
                    "movies_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
