package edu.iesam.dam2024.features.superhero.presentation

import android.content.Context
import edu.iesam.dam2024.app.data.api.ApiClient
import edu.iesam.dam2024.features.superhero.data.SuperHeroDataRepository
import edu.iesam.dam2024.features.superhero.data.local.SuperHeroXmlLocalDataSource
import edu.iesam.dam2024.features.superhero.data.remote.SuperHeroApiRemoteDataSource
import edu.iesam.dam2024.features.superhero.data.remote.SuperHeroMockRemoteDataSource
import edu.iesam.dam2024.features.superhero.domain.GetSuperHeroUseCase
import edu.iesam.dam2024.features.superhero.domain.GetSuperHeroesUseCase

class SuperHeroFactory(private val context: Context) {

    private val superHeroMockRemote = SuperHeroMockRemoteDataSource()
    private val superHeroLocal = SuperHeroXmlLocalDataSource(context)
    private val superHeroDataRepository =
        SuperHeroDataRepository(
            getSuperHeroApiRemoteDataSource(),
            superHeroMockRemote,
            superHeroLocal
        )
    private val getSuperHeroUseCase = GetSuperHeroUseCase(superHeroDataRepository)
    private val getSuperHeroesUseCase = GetSuperHeroesUseCase(superHeroDataRepository)

    fun buildViewModel(): SuperHeroesViewModel {
        return SuperHeroesViewModel(getSuperHeroesUseCase)
    }

    fun buildSuperHeroDetailViewModel(): SuperHeroDetailViewModel {
        return SuperHeroDetailViewModel(getSuperHeroUseCase)
    }

    private fun getSuperHeroApiRemoteDataSource(): SuperHeroApiRemoteDataSource {
        val superHeroService = ApiClient.provideSuperHeroService()
        return SuperHeroApiRemoteDataSource(superHeroService)
    }
}