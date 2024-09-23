package edu.iesam.dam2024.feature.superhero.domain

interface SuperHeroRepository {

    fun getSuperHeroes(): List<SuperHero>

}