package edu.iesam.dam2024.features.movies.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.iesam.dam2024.app.domain.ErrorApp
import edu.iesam.dam2024.features.movies.domain.GetMoviesUseCase
import edu.iesam.dam2024.features.movies.domain.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class MoviesViewModel(
    private val getMoviesUseCase: GetMoviesUseCase
) : ViewModel() {

    private val _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState> = _uiState

    fun viewCreated() {
        _uiState.value = (UiState(isLoading = true))
        viewModelScope.launch(Dispatchers.IO) {
            val movies = getMoviesUseCase.invoke()
            _uiState.postValue(UiState(movies = movies))
        }
    }

    data class UiState(
        val isLoading: Boolean = false,
        val errorApp: ErrorApp? = null,
        val movies: List<Movie>? = null
    )
}