package edu.iesam.dam2024.feature.movies.data.remote

import edu.iesam.dam2024.feature.movies.domain.Movie

/**
 * Naming = Modelo + Tecnología + RemoteDataSource
 */

class MovieMockRemoteDataSource {

    private val movies = listOf(
        Movie("1", "tittle1", "poster1"),
        Movie("2", "tittle2", "poster2"),
        Movie("3", "tittle3", "poster3"),
        Movie(title = "tittle4", poster = "poster4", id = "4")
    )

    fun getMovies(): List<Movie> {
        return movies
    }

    fun getMovie(movieId: String): Movie? {
        return movies.firstOrNull() { movie ->
            movie.id == movieId
        }
    }
}