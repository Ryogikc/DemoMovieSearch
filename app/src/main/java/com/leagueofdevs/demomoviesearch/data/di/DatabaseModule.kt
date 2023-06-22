package com.leagueofdevs.demomoviesearch.data.di

import android.content.Context
import androidx.room.Room
import com.leagueofdevs.demomoviesearch.data.FavoriteMovieDao
import com.leagueofdevs.demomoviesearch.data.db.MoviesDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): MoviesDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            MoviesDatabase::class.java,
            "Movies.db"
        ).build()
    }

    @Provides
    fun provideFavoriteMovieDao(favoriteMovieDatabase: MoviesDatabase): FavoriteMovieDao =
        favoriteMovieDatabase.movieDao()
}
