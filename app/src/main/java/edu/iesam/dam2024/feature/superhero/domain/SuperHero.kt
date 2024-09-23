package edu.iesam.dam2024.feature.superhero.domain

data class SuperHero(
    val id: String,
    val name: String,
    val slug: String,
    val powerstats: PowerStats,
    val appearance: Appearance,
    val biography: Biography,
    val work: Work,
    val connections: Connections
)