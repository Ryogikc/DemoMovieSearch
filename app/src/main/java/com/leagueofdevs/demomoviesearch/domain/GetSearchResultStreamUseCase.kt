package com.leagueofdevs.demomoviesearch.domain

import androidx.paging.PagingData
import com.leagueofdevs.demomoviesearch.data.Search
import com.leagueofdevs.demomoviesearch.data.repositories.FilmRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSearchResultStreamUseCase @Inject constructor(private val repository: FilmRepository) {
    operator fun invoke(title: String, isMovie: Boolean): Flow<PagingData<Search>> {
        return repository.getSearchResultStream(query = title, isMovie = isMovie)
    }
}
