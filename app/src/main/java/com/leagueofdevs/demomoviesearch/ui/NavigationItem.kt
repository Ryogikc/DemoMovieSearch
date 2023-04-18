package com.leagueofdevs.demomoviesearch.ui

import com.leagueofdevs.demomoviesearch.R

sealed class NavigationItem(
    var route: String, var icon: Int,
    var title: String
) {
    object Home : NavigationItem(
        "home",
        com.google.android.material.R.drawable.abc_ic_search_api_material,
        "Search"
    )

    object Favorites : NavigationItem(
        "favorites",
        R.drawable.ic_favorite_unmarked,
        "Favorites"
    )
}
