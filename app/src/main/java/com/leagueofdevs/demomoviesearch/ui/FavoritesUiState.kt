package com.leagueofdevs.demomoviesearch.ui

import com.leagueofdevs.demomoviesearch.data.FavoriteMovie

data class FavoritesUiState(
    val favoritesList: List<FavoriteMovie> = emptyList(),
)
