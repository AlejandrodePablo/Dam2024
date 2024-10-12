package edu.iesam.dam2024.features.pokemon.domain

data class Pokemon(
    val id: String,
    val name: String,
    val abilities: Abilities,
    val height: String,
    val weight: String
)