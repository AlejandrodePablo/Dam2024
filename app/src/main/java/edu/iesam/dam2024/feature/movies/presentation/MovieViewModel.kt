package edu.iesam.dam2024.feature.movies.presentation

import androidx.lifecycle.ViewModel
import edu.iesam.dam2024.feature.movies.domain.GetMovieUseCase
import edu.iesam.dam2024.feature.movies.domain.GetMoviesUseCase
import edu.iesam.dam2024.feature.movies.domain.Movie

class MovieViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val getMovieUseCase: GetMovieUseCase
) : ViewModel() {

    fun viewCreated(): List<Movie> {
        return getMoviesUseCase.invoke()
    }


    fun itemSelected(movieId: String): Movie? {
        return getMovieUseCase.invoke(movieId)
    }

}