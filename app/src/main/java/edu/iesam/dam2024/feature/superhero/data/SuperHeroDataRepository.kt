package edu.iesam.dam2024.feature.superhero.data

import edu.iesam.dam2024.feature.superhero.data.remote.SuperHeroMockRemoteDataSource
import edu.iesam.dam2024.feature.superhero.domain.SuperHero
import edu.iesam.dam2024.feature.superhero.domain.SuperHeroRepository

class SuperHeroDataRepository(private val superHeroMockRemoteDataSource: SuperHeroMockRemoteDataSource) :
    SuperHeroRepository {

    override fun getSuperHeroes(): List<SuperHero> {
        return superHeroMockRemoteDataSource.getSuperHeroes()
    }

    override fun getSuperHero(superHeroId: String): SuperHero? {
        return superHeroMockRemoteDataSource.getSuperHero(superHeroId)
    }

}