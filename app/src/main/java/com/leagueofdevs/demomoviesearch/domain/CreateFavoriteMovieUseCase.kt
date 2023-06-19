package com.leagueofdevs.demomoviesearch.domain

import com.leagueofdevs.demomoviesearch.data.repositories.FavoriteMovieRepository
import javax.inject.Inject

class CreateFavoriteMovieUseCase @Inject constructor(
    private val repository: FavoriteMovieRepository
) {
    suspend operator fun invoke(
        imdbID: String,
        title: String,
        genre: String,
        plot: String,
        poster: String
    ) {
        return repository.createFavoriteMovie(
            imdbID = imdbID, title = title, genre = genre,
            plot = plot,
            poster = poster,
        )
    }
}
