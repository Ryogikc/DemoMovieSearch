package com.leagueofdevs.demomoviesearch.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.leagueofdevs.demomoviesearch.data.repositories.FilmRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class GalleryViewModel @Inject constructor(
    private val repository: FilmRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(GalleryUiState())
    val uiState: StateFlow<GalleryUiState> = _uiState.asStateFlow()
    var titleToSearch by mutableStateOf("")

    fun searchByMovie() {
        _uiState.update { currentState ->
            currentState.copy(
                list = repository.getSearchResultStream(titleToSearch, true).cachedIn(viewModelScope)
            )
        }
    }

    fun searchBySeries() {
        _uiState.update { currentState ->
            currentState.copy(
                list = repository.getSearchResultStream(titleToSearch, false).cachedIn(viewModelScope)
            )
        }
    }

    fun updateTitleToSearch(titleByUser: String) {
        titleToSearch = titleByUser
    }
}
