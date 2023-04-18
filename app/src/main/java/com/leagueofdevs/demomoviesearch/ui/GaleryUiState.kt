package com.leagueofdevs.demomoviesearch.ui

import androidx.paging.PagingData
import com.leagueofdevs.demomoviesearch.data.Search
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

data class GalleryUiState(
    val list: Flow<PagingData<Search>> = emptyFlow(),
)
