package edu.iesam.dam2024.features.superhero.domain

class GetSuperHeroUseCase(private val superHeroRepository: SuperHeroRepository) {

    operator fun invoke(superHeroId: String): SuperHero? {
        return superHeroRepository.getSuperHero(superHeroId)
    }

}