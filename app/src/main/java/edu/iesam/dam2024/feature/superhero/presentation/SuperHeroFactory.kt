package edu.iesam.dam2024.feature.superhero.presentation

import edu.iesam.dam2024.feature.superhero.data.SuperHeroDataRepository
import edu.iesam.dam2024.feature.superhero.data.remote.SuperHeroMockRemoteDataSource
import edu.iesam.dam2024.feature.superhero.domain.GetSuperHeroUseCase
import edu.iesam.dam2024.feature.superhero.domain.GetSuperHeroesUseCase

class SuperHeroFactory {

    fun buildViewModel(): SuperHeroViewModel {
        return SuperHeroViewModel(
            GetSuperHeroesUseCase(
                SuperHeroDataRepository(
                    superHeroMockRemoteDataSource = SuperHeroMockRemoteDataSource()
                )
            ),
            getSuperHeroUseCase = GetSuperHeroUseCase(
                SuperHeroDataRepository(superHeroMockRemoteDataSource = SuperHeroMockRemoteDataSource())
            )
        )
    }
}