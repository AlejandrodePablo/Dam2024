package edu.iesam.dam2024.feature.movies.domain

class GetMovieUseCase(private val movieRepository: MovieRepository) {

    operator fun invoke(movieId: String): Movie? {
        return movieRepository.getMovie(movieId)
    }
}