package com.leagueofdevs.demomoviesearch.data

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteMovieDao {
    @Query("SELECT * FROM favorite_movies")
    fun getFavoriteMovies(): Flow<List<FavoriteMovieEntity>>

    @Query("DELETE FROM favorite_movies")
    suspend fun deleteAll()

    @Upsert
    suspend fun insertFavoriteMovie(favoriteMovie: FavoriteMovieEntity)

    @Query("DELETE FROM favorite_movies WHERE imdbID = :imdbID")
    suspend fun deleteFavoriteMovie(imdbID: String)

    @Query("SELECT EXISTS( SELECT 1 FROM favorite_movies WHERE imdbID = :imdbID LIMIT 1)")
    suspend fun isFavoriteMovie(imdbID: String): Boolean
}
