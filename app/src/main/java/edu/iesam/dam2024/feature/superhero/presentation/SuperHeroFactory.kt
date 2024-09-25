package edu.iesam.dam2024.feature.superhero.presentation

import edu.iesam.dam2024.feature.superhero.data.SuperHeroDataRepository
import edu.iesam.dam2024.feature.superhero.data.remote.SuperHeroMockRemoteDataSource
import edu.iesam.dam2024.feature.superhero.domain.GetSuperHeroUseCase
import edu.iesam.dam2024.feature.superhero.domain.GetSuperHeroesUseCase

class SuperHeroFactory {

    private val superHeroMockRemoteDataSource = SuperHeroMockRemoteDataSource()
    private val superHeroDataRepository = SuperHeroDataRepository(superHeroMockRemoteDataSource)
    private val getSuperHeroUseCase = GetSuperHeroUseCase(superHeroDataRepository)
    private val getSuperHeroesUseCase = GetSuperHeroesUseCase(superHeroDataRepository)

    fun buildViewModel(): SuperHeroViewModel {
        return SuperHeroViewModel(getSuperHeroesUseCase, getSuperHeroUseCase)
    }
}