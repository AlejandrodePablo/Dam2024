package edu.iesam.dam2024.features.pokemon.data.remote

import edu.iesam.dam2024.features.pokemon.domain.Pokemon

class PokemonMockRemoteDataSource {

    private val pokemonList = listOf(
        Pokemon(
            "1",
            "Bulbasaur",
            "sword-dance",
            "6.9",
            "6.9",
            "https://static.wikia.nocookie.net/nintendo-lastchance/images/f/f0/BULBASAUSA.png/revision/latest?cb=20150710203644"
        ),
        Pokemon(
            "2",
            "Ivysaur",
            "slash",
            "13.0",
            "13.0",
            "https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/full/002.png"
        ),
        Pokemon(
            "3",
            "Venusaur",
            "razor-wind",
            "100.0",
            "100.0",
            "https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/full/003.png"
        )

    )

    fun getPokemonList(): List<Pokemon> {
        return pokemonList
    }

    fun getPokemon(pokemonId: String): Pokemon? {
        return pokemonList.firstOrNull() { pokemon ->
            pokemon.id == pokemonId
        }

    }
}