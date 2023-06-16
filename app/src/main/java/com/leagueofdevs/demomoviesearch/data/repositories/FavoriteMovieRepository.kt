package com.leagueofdevs.demomoviesearch.data.repositories

import com.leagueofdevs.demomoviesearch.data.FavoriteMovie
import com.leagueofdevs.demomoviesearch.data.FavoriteMovieDao
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FavoriteMovieRepository @Inject constructor(
    private val favoriteMovieDao: FavoriteMovieDao
) {
    suspend fun createFavoriteMovie(
        imdbID: String,
        title: String,
        genre: String,
        plot: String,
        poster: String,
    ) {
        val favoriteMovie = FavoriteMovie(imdbID, title, genre, plot, poster)
        favoriteMovieDao.insertFavoriteMovie(favoriteMovie)
    }

    fun getFavoriteMovies() = favoriteMovieDao.getFavoriteMovies()

    suspend fun isMovieFavorite(imdbID: String) = favoriteMovieDao.isFavoriteMovie(imdbID)

}
