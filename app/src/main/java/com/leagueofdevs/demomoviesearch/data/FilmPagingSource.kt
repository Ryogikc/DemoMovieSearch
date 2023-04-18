package com.leagueofdevs.demomoviesearch.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.leagueofdevs.demomoviesearch.data.api.FilmService

private const val FILM_STARTING_PAGE_INDEX = 1

class FilmPagingSource(
    private val service: FilmService,
    private val query: String,
    private val isMovie: Boolean,
): PagingSource<Int, Search>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Search> {
        val page = params.key ?: FILM_STARTING_PAGE_INDEX
        return try {
            val response = if (isMovie) {
                service.getMoviesByTitle(query, page)
            } else {
                service.getSeriesByTitle(query, page)
            }
            val film = response.films
            LoadResult.Page(
                data = film,
                prevKey = if (page == FILM_STARTING_PAGE_INDEX) null else page - 1,
                nextKey = if (page == response.totalResults) null else page + 1
            )
        } catch (exception: java.lang.Exception) {
            LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Search>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey
        }
    }
}
