package edu.iesam.dam2024.features.superhero.data

import edu.iesam.dam2024.features.superhero.data.remote.SuperHeroMockRemoteDataSource
import edu.iesam.dam2024.features.superhero.domain.SuperHero
import edu.iesam.dam2024.features.superhero.domain.SuperHeroRepository

class SuperHeroDataRepository(private val superHeroMockRemoteDataSource: SuperHeroMockRemoteDataSource) :
    SuperHeroRepository {

    override fun getSuperHeroes(): List<SuperHero> {
        return superHeroMockRemoteDataSource.getSuperHeroes()
    }

    override fun getSuperHero(superHeroId: String): SuperHero? {
        return superHeroMockRemoteDataSource.getSuperHero(superHeroId)
    }

}