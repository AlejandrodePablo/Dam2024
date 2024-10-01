package edu.iesam.dam2024.features.superhero.data.remote

import edu.iesam.dam2024.features.superhero.domain.Appearance
import edu.iesam.dam2024.features.superhero.domain.Biography
import edu.iesam.dam2024.features.superhero.domain.Connections
import edu.iesam.dam2024.features.superhero.domain.PowerStats
import edu.iesam.dam2024.features.superhero.domain.SuperHero
import edu.iesam.dam2024.features.superhero.domain.Work

class SuperHeroMockRemoteDataSource {

    private val superHeroes = listOf(
        SuperHero(
            id = "1",
            name = "A-Bomb",
            slug = "1-a-bomb",
            powerStats = PowerStats(
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
        ), SuperHero(
            id = "2",
            name = "Abe Sapien",
            slug = "2-abe-sapien",
            powerStats = PowerStats(
                intelligence = 88,
                strength = 28,
                speed = 35,
                durability = 65,
                power = 100,
                combat = 85
            ),
            appearance = Appearance(
                gender = "Male",
                race = "Icthyo Sapien",
                height = listOf("6'3", "191 cm"),
                weight = listOf("145 lb", "65 kg"),
                eyeColor = "Blue",
                hairColor = "No Hair"
            ),
            biography = Biography(
                fullName = "Abraham Sapien",
                alterEgos = "No alter egos found.",
                aliases = listOf("Langdon Everett Caul", "Abraham Sapien", "Langdon Caul"),
                placeOfBirth = "-",
                firstAppearance = "Hellboy: Seed of Destruction (1993)",
                publisher = "Dark Horse Comics",
                alignment = "good"
            ),
            work = Work(
                occupation = "Paranormal Investigator",
                base = "-"
            ),
            connections = Connections(
                groupAffiliation = "Bureau for Paranormal Research and Defense",
                relatives = "Edith Howard (wife, deceased)"
            )
        )
    )

    fun getSuperHeroes(): List<SuperHero> {
        return superHeroes
    }

    fun getSuperHero(superHeroId: String): SuperHero? {
        return superHeroes.firstOrNull() { superHero ->
            superHero.id == superHeroId
        }
    }
}