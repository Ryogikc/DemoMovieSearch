package com.leagueofdevs.demomoviesearch.domain

import com.leagueofdevs.demomoviesearch.data.repositories.FavoriteMovieRepository
import javax.inject.Inject

class DeleteFavoriteByIdUseCase @Inject constructor(
    private val repository: FavoriteMovieRepository
) {
    suspend operator fun invoke(imdbID: String){
        return repository.deleteFavoriteById(imdbID)
    }
}
