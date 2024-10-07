package edu.iesam.dam2024.features.movies.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.iesam.dam2024.app.domain.ErrorApp
import edu.iesam.dam2024.features.movies.domain.GetMoviesUseCase
import edu.iesam.dam2024.features.movies.domain.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MoviesViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,

    ) : ViewModel() {

    private val _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState> = _uiState

    fun viewCreated() {
        viewModelScope.launch(Dispatchers.IO) {
            val movies = getMoviesUseCase.invoke()
            //postValue origen: Default, IO, Main destino: Main
            _uiState.postValue(UiState(movies = movies))
        }
    }

    data class UiState(
        val isLoading: Boolean = false,
        val errorApp: ErrorApp? = null,
        val movies: List<Movie>? = null
    )
}