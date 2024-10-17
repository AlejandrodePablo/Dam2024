package edu.iesam.dam2024.features.pokemon.data.local

import android.content.Context
import com.google.gson.Gson
import edu.iesam.dam2024.features.pokemon.domain.Pokemon

class PokemonXmlLocalDataSource(private val context: Context) {

    private val sharedPref = context.getSharedPreferences(
        "pokemons", Context.MODE_PRIVATE
    )

    private val gson = Gson()

    fun save(pokemon: Pokemon) {
        val editor = sharedPref.edit()
        val pokemonJson = gson.toJson(pokemon)
        editor.putString(pokemon.id, pokemonJson)
        editor.apply()
    }

    fun findById(pokemonId: String): Pokemon? {
        return sharedPref.getString(pokemonId, null).let {
            gson.fromJson(it, Pokemon::class.java)
        }
    }

    fun findAll(): List<Pokemon> {
        val pokemons = mutableListOf<Pokemon>()
        val mapPokemon = sharedPref.all
        mapPokemon.values.forEach { jsonPokemon ->
            val pokemon = gson.fromJson(jsonPokemon as String, Pokemon::class.java)
            pokemons.add(pokemon)
        }
        return pokemons
    }

    fun saveAll(pokemons: List<Pokemon>) {
        val editor = sharedPref.edit()
        pokemons.forEach {
            editor.putString(it.id, gson.toJson(it))
        }
        editor.apply()
    }

    fun delete() {
        sharedPref.edit().clear().apply()
    }

    fun deleteById(pokemonId: String) {
        sharedPref.edit().remove(pokemonId).apply()
    }

    fun save(pokemon: String) {

    }

}