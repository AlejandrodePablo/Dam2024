package edu.iesam.dam2024.features.superhero.data.remote

import edu.iesam.dam2024.features.superhero.domain.Appearance
import edu.iesam.dam2024.features.superhero.domain.Biography
import edu.iesam.dam2024.features.superhero.domain.Connections
import edu.iesam.dam2024.features.superhero.domain.PowerStats
import edu.iesam.dam2024.features.superhero.domain.SuperHero
import edu.iesam.dam2024.features.superhero.domain.Work

class SuperHeroApiRemoteDataSource(private val superHeroService: SuperHeroService) {

    suspend fun getSuperHeroes(): List<SuperHero> {
        val response = superHeroService.requestSuperHeroes()
        if (response.isSuccessful) {
            return response.body()!!.map {
                it.toModel()
            }
        } else {
            return emptyList()
        }
    }

    suspend fun getSuperHero(superheroId: String): SuperHero {
        val response = superHeroService.requestSuperHero(superheroId)
        if (response.isSuccessful) {
            return response.body()!!.toModel()
        } else {
            return SuperHero(
                id = "Error",
                name = "Error",
                slug = "Error",
                powerStats = PowerStats(
                    intelligence = 0,
                    strength = 0,
                    speed = 0,
                    durability = 0,
                    power = 0,
                    combat = 0
                ),
                appearance = Appearance(
                    gender = "error",
                    race = "error",
                    height = listOf("error", "error"),
                    weight = listOf("error", "error"),
                    eyeColor = "error",
                    hairColor = "error"
                ),
                biography = Biography(
                    fullName = "error",
                    alterEgos = "error",
                    aliases = listOf("error"),
                    placeOfBirth = "error",
                    firstAppearance = "error",
                    publisher = "error",
                    alignment = "error"
                ),
                work = Work(
                    occupation = "error",
                    base = "error"
                ),
                connections = Connections(
                    groupAffiliation = "error",
                    relatives = "error"
                ),
                images = "error"
            )
        }
    }

}