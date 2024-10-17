package edu.iesam.dam2024.features.pokemon.data

import edu.iesam.dam2024.features.pokemon.data.local.PokemonXmlLocalDataSource
import edu.iesam.dam2024.features.pokemon.data.remote.PokemonMockRemoteDataSource
import edu.iesam.dam2024.features.pokemon.domain.Pokemon
import edu.iesam.dam2024.features.pokemon.domain.PokemonRepository

class PokemonDataRepository(
    private val localDataSource: PokemonXmlLocalDataSource,
    private val remoteDataSource: PokemonMockRemoteDataSource
) : PokemonRepository {

    override fun getPokemon(pokemonId: String): Pokemon? {
        val localPokemon = localDataSource.findById(pokemonId)
        if (localPokemon != null) {
            remoteDataSource.getPokemon(pokemonId)?.let {
                localDataSource.save(it)
                return it
            }
        }
        return null
    }

    override fun getPokemons(): List<Pokemon> {
        val pokemonFromLocal = localDataSource.findAll()
        if (pokemonFromLocal.isEmpty()) {
            val pokemonFromRemote = remoteDataSource.getPokemonList()
            localDataSource.saveAll(pokemonFromRemote)
            return pokemonFromRemote
        } else {
            return pokemonFromLocal
        }
        return emptyList()
    }

}