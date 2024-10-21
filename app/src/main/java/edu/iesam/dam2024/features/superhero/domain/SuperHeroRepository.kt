package edu.iesam.dam2024.features.superhero.domain

interface SuperHeroRepository {

    suspend fun getSuperHeroes(): List<SuperHero>
    suspend fun getSuperHero(superHeroId: String): SuperHero?

}