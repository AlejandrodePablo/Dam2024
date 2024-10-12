package edu.iesam.dam2024.features.pokemon.domain

interface PokemonRepository {

    fun getPokemon(pokemonId: String): Pokemon?
    fun getPokemons(): List<Pokemon>
}