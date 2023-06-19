package com.leagueofdevs.demomoviesearch.domain

import com.leagueofdevs.demomoviesearch.data.repositories.FavoriteMovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetFavoriteMoviesUseCase @Inject constructor(
    private val repository: FavoriteMovieRepository) {
    operator fun invoke(): Flow<List<FavoriteMovie>> {
        return repository.getFavoriteMovies()
    }
}
