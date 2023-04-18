package com.leagueofdevs.demomoviesearch.data.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.leagueofdevs.demomoviesearch.data.Search
import com.leagueofdevs.demomoviesearch.data.FilmPagingSource
import com.leagueofdevs.demomoviesearch.data.api.FilmService
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FilmRepository @Inject constructor(private val service: FilmService) {

    fun getSearchResultStream(query: String, isMovie: Boolean): Flow<PagingData<Search>> {
        return Pager(
            config = PagingConfig(enablePlaceholders = false, pageSize = NETWORK_PAGE_SIZE),
            pagingSourceFactory = {FilmPagingSource(service, query, isMovie)}
        ).flow
    }

    companion object {
        private const val NETWORK_PAGE_SIZE = 25
    }
}
