package edu.iesam.dam2024.features.superhero.data

import edu.iesam.dam2024.features.superhero.data.local.SuperHeroXmlLocalDataSource
import edu.iesam.dam2024.features.superhero.data.remote.SuperHeroMockRemoteDataSource
import edu.iesam.dam2024.features.superhero.domain.SuperHero
import edu.iesam.dam2024.features.superhero.domain.SuperHeroRepository

class SuperHeroDataRepository(
    private val superHeroMockRemoteDataSource: SuperHeroMockRemoteDataSource,
    private val local: SuperHeroXmlLocalDataSource
) :
    SuperHeroRepository {


    override fun getSuperHeroes(): List<SuperHero> {
        val superHeroesFromLocal = local.findAll()
        if (superHeroesFromLocal.isEmpty()) {
            val superHeroesFromRemote = superHeroMockRemoteDataSource.getSuperHeroes()
            local.saveAll(superHeroesFromRemote)
            return superHeroesFromRemote
        } else {
            return superHeroesFromLocal
        }
    }

    override fun getSuperHero(superHeroId: String): SuperHero? {
        val localSuperHero = local.findById(superHeroId)
        if (localSuperHero != null) {
            superHeroMockRemoteDataSource.getSuperHero(superHeroId)?.let {
                local.save(it)
                return it
            }
        }
        return localSuperHero
    }

}