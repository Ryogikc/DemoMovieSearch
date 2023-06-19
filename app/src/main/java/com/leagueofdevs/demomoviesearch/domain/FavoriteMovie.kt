package com.leagueofdevs.demomoviesearch.domain

import com.leagueofdevs.demomoviesearch.data.FavoriteMovieEntity

data class FavoriteMovie(
    val imdbID: String,
    val title: String,
    val genre: String,
    val plot: String,
    val poster: String,
)

fun FavoriteMovieEntity.toDomain() = FavoriteMovie(imdbID, title, genre, plot, poster)