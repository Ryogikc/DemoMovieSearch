package com.leagueofdevs.demomoviesearch.data.di

import com.leagueofdevs.demomoviesearch.data.api.FilmService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideFilmService(): FilmService{
        return FilmService.create()
    }
}
