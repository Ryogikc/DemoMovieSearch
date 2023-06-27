package com.leagueofdevs.demomoviesearch.ui

import androidx.lifecycle.ViewModel
import com.leagueofdevs.demomoviesearch.domain.CreateFavoriteMovieUseCase
import com.leagueofdevs.demomoviesearch.domain.FavoriteMovie
import com.leagueofdevs.demomoviesearch.domain.GetFavoriteMoviesUseCase
import com.leagueofdevs.demomoviesearch.domain.IsMovieFavoriteUseCase
import com.leagueofdevs.demomoviesearch.domain.DeleteFavoriteByIdUseCase
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
    private val deleteFavoriteByIdUseCase: DeleteFavoriteByIdUseCase,
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
            _showSnackbar.value = true
        } else {
            _showSnackbar.value = false
            createFavoriteMovieUseCase(imdbId, title, genre, plot, poster)
        }
    }

    suspend fun deleteFavoriteById(imdbId: String) {
        deleteFavoriteByIdUseCase(imdbId)
    }

    fun dismissSnackBar(){
        _showSnackbar.value = false
    }
}
