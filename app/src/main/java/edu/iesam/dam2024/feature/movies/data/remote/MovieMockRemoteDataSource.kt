package edu.iesam.dam2024.feature.movies.data.remote

import edu.iesam.dam2024.feature.movies.domain.Movie

/**
 * Naming = Modelo + Tecnología + RemoteDataSource
 */

class MovieMockRemoteDataSource {

    fun getMovies(): List<Movie> {
        return listOf(
            Movie("1", "tittle1", "poster1"),
            Movie("2", "tittle2", "poster2"),
            Movie("3", "tittle3", "poster3"),
            Movie(tittle = "tittle4", poster = "poster4", id = "4")
        )
    }

    fun getMovie(movieId: String): Movie? {
        return getMovies().firstOrNull() {
            //it es un objeto Movie del listado
            it.id == movieId
        }
    }
}