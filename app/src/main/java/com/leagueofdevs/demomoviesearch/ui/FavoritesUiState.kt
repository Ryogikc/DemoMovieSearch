package com.leagueofdevs.demomoviesearch.ui

import com.leagueofdevs.demomoviesearch.data.FavoriteMovieEntity

data class FavoritesUiState(
    val favoritesList: List<FavoriteMovieEntity> = emptyList(),
)
