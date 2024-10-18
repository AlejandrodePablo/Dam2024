package edu.iesam.dam2024.features.superhero.data

import edu.iesam.dam2024.features.superhero.data.local.SuperHeroXmlLocalDataSource
import edu.iesam.dam2024.features.superhero.data.remote.SuperHeroApiRemoteDataSource
import edu.iesam.dam2024.features.superhero.data.remote.SuperHeroMockRemoteDataSource
import edu.iesam.dam2024.features.superhero.domain.SuperHero
import edu.iesam.dam2024.features.superhero.domain.SuperHeroRepository

class SuperHeroDataRepository(
    private val remote: SuperHeroApiRemoteDataSource,
    private val mockremote: SuperHeroMockRemoteDataSource,
    private val local: SuperHeroXmlLocalDataSource
) :
    SuperHeroRepository {


    override suspend fun getSuperHeroes(): List<SuperHero> {
        val superHeroesFromLocal = local.findAll()
        if (superHeroesFromLocal.isEmpty()) {
            val superHeroesFromRemote = remote.getSuperHeroes()
            local.saveAll(superHeroesFromRemote)
            return superHeroesFromRemote
        } else {
            return superHeroesFromLocal
        }
    }

    override fun getSuperHero(superHeroId: String): SuperHero? {
        val localSuperHero = local.findById(superHeroId)
        if (localSuperHero != null) {
            mockremote.getSuperHero(superHeroId)?.let {
                local.save(it)
                return it
            }
        }
        return localSuperHero
    }

}