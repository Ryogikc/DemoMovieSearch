package com.leagueofdevs.demomoviesearch.ui

import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.leagueofdevs.demomoviesearch.data.FavoriteMovie
import com.leagueofdevs.demomoviesearch.data.repositories.FavoriteMovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject internal constructor(
    private val favoriteMovieRepository: FavoriteMovieRepository
) : ViewModel() {

    val favoriteMovieList: Flow<List<FavoriteMovie>> =
        favoriteMovieRepository.getFavoriteMovies()

    suspend fun newFavoriteMovie(
        imdbId: String,
        title: String,
        genre: String,
        plot: String,
        poster: String
    ) {

        if(favoriteMovieRepository.isMovieFavorite(imdbId)) {
            // variable de estado que ya existe
        } else {
            favoriteMovieRepository.createFavoriteMovie(imdbId, title, genre, plot, poster)
        }
    }
}
