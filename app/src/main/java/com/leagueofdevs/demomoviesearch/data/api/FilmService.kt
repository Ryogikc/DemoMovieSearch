package com.leagueofdevs.demomoviesearch.data.api

import com.leagueofdevs.demomoviesearch.BuildConfig
import com.leagueofdevs.demomoviesearch.data.FilmSearchResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface FilmService {

    @GET("?type=movie")
    suspend fun getMoviesByTitle(
        @Query(value = "s") searchTitle: String,
        @Query("page") page: Int,
        @Query("apikey") clientId: String = BuildConfig.API_KEY
    ): FilmSearchResponse

    @GET("?type=series")
    suspend fun getSeriesByTitle(
        @Query(value = "s") searchTitle: String,
        @Query("page") page: Int,
        @Query("apikey") clientId: String = BuildConfig.API_KEY
    ): FilmSearchResponse

    companion object {
        private const val BASE_URL = "https://www.omdbapi.com/"

        fun create(): FilmService {
            val logger =
                HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(FilmService::class.java)
        }
    }
}
