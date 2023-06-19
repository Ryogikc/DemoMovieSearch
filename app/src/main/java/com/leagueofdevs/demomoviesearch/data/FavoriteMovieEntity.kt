package com.leagueofdevs.demomoviesearch.data

import androidx.room.*

@Entity(tableName = "favorite_movies",)
data class FavoriteMovieEntity(
    @PrimaryKey @ColumnInfo(name = "imdbID") val imdbID: String,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "genre") val genre: String,
    @ColumnInfo(name = "plot") val plot: String,
    @ColumnInfo(name = "poster") val poster: String,
)
