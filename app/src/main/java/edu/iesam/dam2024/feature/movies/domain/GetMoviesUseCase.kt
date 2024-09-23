package edu.iesam.dam2024.feature.movies.domain

/**
 * Naming= Verbo(Acción)+ Modelo + UseCase
 */

class GetMoviesUseCase(private val movieRepository: MovieRepository) {

    operator fun invoke(): List<Movie> {
        return movieRepository.getMovies()
    }
}