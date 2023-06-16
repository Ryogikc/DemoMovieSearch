package com.leagueofdevs.demomoviesearch.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.leagueofdevs.demomoviesearch.data.FavoriteMovie

@Composable
fun FavoriteMovieGrid(
    favoritesList: List<FavoriteMovie>,
    modifier: Modifier = Modifier,
) {
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier.height(650.dp)
    ) {
        items(
            items = favoritesList,
            key = { it.imdbID }
        ) { favorite ->
            FavoriteItem(favoriteMovie = favorite)
        }
    }
}
