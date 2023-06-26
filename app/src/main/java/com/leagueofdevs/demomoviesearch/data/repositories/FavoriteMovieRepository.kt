package com.leagueofdevs.demomoviesearch.data.repositories

import com.leagueofdevs.demomoviesearch.data.FavoriteMovieEntity
import com.leagueofdevs.demomoviesearch.data.FavoriteMovieDao
import com.leagueofdevs.demomoviesearch.domain.FavoriteMovie
import com.leagueofdevs.demomoviesearch.domain.toDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
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
        val favoriteMovieEntity = FavoriteMovieEntity(imdbID, title, genre, plot, poster)
        favoriteMovieDao.insertFavoriteMovie(favoriteMovieEntity)
    }

    fun getFavoriteMovies(): Flow<List<FavoriteMovie>> {
        val response: Flow<List<FavoriteMovieEntity>> = favoriteMovieDao.getFavoriteMovies()
        return response.map { it.map { flow -> flow.toDomain() } }
    }

    suspend fun isMovieFavorite(imdbID: String) = favoriteMovieDao.isFavoriteMovie(imdbID)

    suspend fun deleteFavoriteById(imdbID: String) = favoriteMovieDao.deleteFavoriteMovie(imdbID)
}
