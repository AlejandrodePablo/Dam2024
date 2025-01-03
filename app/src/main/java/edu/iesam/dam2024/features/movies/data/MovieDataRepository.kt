package edu.iesam.dam2024.features.movies.data

import edu.iesam.dam2024.features.movies.data.local.MovieXmlLocalDataSource
import edu.iesam.dam2024.features.movies.data.remote.MovieMockRemoteDataSource
import edu.iesam.dam2024.features.movies.domain.Movie
import edu.iesam.dam2024.features.movies.domain.MovieRepository
import org.koin.core.annotation.Single

/**
 * Naming = Modelo + DataRepository
 */

@Single
class MovieDataRepository(
    private val local: MovieXmlLocalDataSource,
    private val mockRemoteDataSource: MovieMockRemoteDataSource
) :
    MovieRepository {

    override fun getMovies(): List<Movie> {
        val movieFromLocal = local.findAll()
        if (movieFromLocal.isEmpty()) {
            val moviesFromRemote = mockRemoteDataSource.getMovies()
            local.saveAll(moviesFromRemote)
            return moviesFromRemote
        } else {
            return movieFromLocal
        }
    }

    override fun getMovie(movieId: String): Movie? {
        val localMovie = local.findById(movieId)
        if (localMovie != null) {
            mockRemoteDataSource.getMovie(movieId)?.let {
                local.save(it)
                return it

            }
        }
        return localMovie
    }
}
