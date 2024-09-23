package edu.iesam.dam2024.feature.superhero.domain

class GetSuperHeroesUseCase(private val superHeroRepository: SuperHeroRepository) {

    operator fun invoke(): List<SuperHero> {
        return superHeroRepository.getSuperHeroes()
    }

}