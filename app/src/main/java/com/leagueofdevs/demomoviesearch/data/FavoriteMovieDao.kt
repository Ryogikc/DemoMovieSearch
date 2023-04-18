package com.leagueofdevs.demomoviesearch.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteMovieDao {
    @Query("SELECT * FROM favorite_movies")
    fun getFavoriteMovies(): Flow<List<FavoriteMovie>>

    @Query("DELETE FROM favorite_movies")
    suspend fun deleteAll()

    @Insert
    suspend fun insertFavoriteMovie(favoriteMovie: FavoriteMovie): Long

    @Query("DELETE FROM favorite_movies WHERE imdbID = :imdbID")
    suspend fun deleteFavoriteMovie(imdbID: String)
}
