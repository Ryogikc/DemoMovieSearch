package com.leagueofdevs.demomoviesearch.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.paging.compose.LazyPagingItems
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.PagingData
import androidx.paging.compose.collectAsLazyPagingItems
import com.leagueofdevs.demomoviesearch.data.Search
import kotlinx.coroutines.flow.Flow

@Composable
fun MovieGrid(
    movieList: Flow<PagingData<Search>>,
    modifier: Modifier = Modifier,
    onAddFavoriteClick: (Search) -> Unit,
    ) {
    val pagingItems: LazyPagingItems<Search> = movieList.collectAsLazyPagingItems()
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier.height(500.dp)
    ) {
        items(
            count = pagingItems.itemCount,
            key = { index ->
                val movie = pagingItems[index]
                movie?.imdbID ?: ""
            }
        ) { index ->
            val item = pagingItems[index] ?: return@items
            MovieItem(movie = item) {
                onAddFavoriteClick(item)
            }
        }
    }
}
