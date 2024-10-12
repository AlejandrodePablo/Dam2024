package edu.iesam.dam2024.features.pokemon.presentation

import android.content.Context
import edu.iesam.dam2024.features.pokemon.data.PokemonDataRepository
import edu.iesam.dam2024.features.pokemon.data.local.PokemonXmlLocalDataSource
import edu.iesam.dam2024.features.pokemon.data.remote.PokemonRemoteDataSource
import edu.iesam.dam2024.features.pokemon.domain.GetPokemonUseCase
import edu.iesam.dam2024.features.pokemon.domain.GetPokemonsUseCase

class PokemonFactory(private val context: Context) {
    private val pokemonRemote = PokemonRemoteDataSource()
    private val pokemonLocal = PokemonXmlLocalDataSource(context)
    private val pokemonDataRepository = PokemonDataRepository(pokemonLocal, pokemonRemote)
    private val getPokemonUseCase = GetPokemonUseCase(pokemonDataRepository)
    private val getPokemonsUseCase = GetPokemonsUseCase(pokemonDataRepository)

    fun getPokemonListViewModel(): PokemonListViewModel {
        return PokemonListViewModel(getPokemonsUseCase)
    }

    fun buildPokemonDetailViewModel(): PokemonDetailViewModel {
        return PokemonDetailViewModel(getPokemonUseCase)
    }
}