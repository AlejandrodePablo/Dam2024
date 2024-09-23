package edu.iesam.dam2024.feature.movies.presentation

import edu.iesam.dam2024.feature.movies.data.MovieDataRepository
import edu.iesam.dam2024.feature.movies.data.remote.MovieMockRemoteDataSource
import edu.iesam.dam2024.feature.movies.domain.GetMovieUseCase
import edu.iesam.dam2024.feature.movies.domain.GetMoviesUseCase

class MovieFactory {

    fun buildViewModel(): MovieViewModel {
        return MovieViewModel(
            getMoviesUseCase = GetMoviesUseCase(
                MovieDataRepository(
                    mockRemoteDataSource = MovieMockRemoteDataSource()
                )
            )
        )
    }

    fun buildViewModel(movieId: String): MovieViewModel {
        return MovieViewModel(
            getMovieUseCase = GetMovieUseCase(
                MovieDataRepository(
                    mockRemoteDataSource = MovieMockRemoteDataSource()
                )
            )
        )
    }
}