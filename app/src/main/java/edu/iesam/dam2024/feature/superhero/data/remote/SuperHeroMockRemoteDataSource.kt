package edu.iesam.dam2024.feature.superhero.data.remote

import edu.iesam.dam2024.feature.superhero.domain.Appearance
import edu.iesam.dam2024.feature.superhero.domain.Biography
import edu.iesam.dam2024.feature.superhero.domain.Connections
import edu.iesam.dam2024.feature.superhero.domain.PowerStats
import edu.iesam.dam2024.feature.superhero.domain.SuperHero
import edu.iesam.dam2024.feature.superhero.domain.Work

class SuperHeroMockRemoteDataSource {

    fun getSuperHeroes(): List<SuperHero> {
        return listOf(
            SuperHero(
                id = "1",
                name = "A-Bomb",
                slug = "1-a-bomb",
                powerstats = PowerStats(
                    intelligence = 38,
                    strength = 100,
                    speed = 17,
                    durability = 80,
                    power = 24,
                    combat = 64
                ),
                appearance = Appearance(
                    gender = "Male",
                    race = "Human",
                    height = listOf("6'8", "203 cm"),
                    weight = listOf("980 lb", "441 kg"),
                    eyeColor = "Yellow",
                    hairColor = "No Hair"
                ),
                biography = Biography(
                    fullName = "Richard Milhouse Jones",
                    alterEgos = "No alter egos found.",
                    aliases = listOf("Rick Jones"),
                    placeOfBirth = "Scarsdale, Arizona",
                    firstAppearance = "Hulk Vol 2 #2 (April, 2008) (as A-Bomb)",
                    publisher = "Marvel Comics",
                    alignment = "good"
                ),
                work = Work(
                    occupation = "Musician, adventurer, author; formerly talk show host",
                    base = "-"
                ),
                connections = Connections(
                    groupAffiliation = "Hulk Family; Excelsior (sponsor), Avengers (honorary member); formerly partner of the Hulk, Captain America and Captain Marvel; Teen Brigade; ally of Rom",
                    relatives = "Marlo Chandler-Jones (wife); Polly (aunt); Mrs. Chandler (mother-in-law); Keith Chandler, Ray Chandler, three unidentified others (brothers-in-law); unidentified father (deceased); Jackie Shorr (alleged mother; unconfirmed)"
                )
            ),

            )
    }
}