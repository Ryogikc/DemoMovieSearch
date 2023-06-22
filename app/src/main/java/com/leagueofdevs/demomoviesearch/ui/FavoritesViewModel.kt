package com.leagueofdevs.demomoviesearch.ui

import androidx.lifecycle.ViewModel
import com.leagueofdevs.demomoviesearch.domain.CreateFavoriteMovieUseCase
import com.leagueofdevs.demomoviesearch.domain.FavoriteMovie
import com.leagueofdevs.demomoviesearch.domain.GetFavoriteMoviesUseCase
import com.leagueofdevs.demomoviesearch.domain.IsMovieFavoriteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject internal constructor(
    getFavoriteMoviesUseCase: GetFavoriteMoviesUseCase,
    private val isFavoriteMovieUseCase: IsMovieFavoriteUseCase,
    private val createFavoriteMovieUseCase: CreateFavoriteMovieUseCase,
) : ViewModel() {
    private val _showSnackbar = MutableStateFlow(false)
    val showSnackbar: StateFlow<Boolean> = _showSnackbar.asStateFlow()

    val favoriteMovieList: Flow<List<FavoriteMovie>> = getFavoriteMoviesUseCase()


    suspend fun newFavoriteMovie(
        imdbId: String,
        title: String,
        genre: String,
        plot: String,
        poster: String
    ) {

        if(isFavoriteMovieUseCase(imdbId)) {
            // variable de estado que ya existe
            _showSnackbar.value = true
        } else {
            _showSnackbar.value = false
            createFavoriteMovieUseCase(imdbId, title, genre, plot, poster)
        }
    }
}
