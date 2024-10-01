package edu.iesam.dam2024.features.movies.data.remote

import edu.iesam.dam2024.features.movies.domain.Movie

/**
 * Naming = Modelo + Tecnología + RemoteDataSource
 */

class MovieMockRemoteDataSource {

    private val movies = listOf(
        Movie(
            "1",
            "tittle1",
            "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/images/lg/692-vibe.jpg"
        ),
        Movie(
            "2",
            "tittle2",
            "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/images/lg/692-vibe.jpg"
        ),
        Movie(
            "3",
            "tittle3",
            "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/images/lg/692-vibe.jpg"
        ),
        Movie(
            title = "tittle4",
            poster = "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/images/lg/692-vibe.jpg",
            id = "4"
        )
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