package edu.iesam.dam2024.features.superhero.data.local

import android.content.Context
import com.google.gson.Gson
import edu.iesam.dam2024.features.superhero.domain.SuperHero

class SuperHeroXmlLocalDataSource(private val context: Context) {

    private val sharedPref = context.getSharedPreferences(
        "superheroes", Context.MODE_PRIVATE
    )

    private val gson = Gson()

    fun save(superHero: SuperHero) {
        sharedPref.edit().apply {
            putString("id", superHero.id)
            putString("name", superHero.name)
            putString("slug", superHero.slug)
            putString("work", superHero.work.toString())
            putString("appearance", superHero.appearance.toString())
            putString("biography", superHero.biography.toString())
            putString("connections", superHero.connections.toString())
            putString("powerStats", superHero.powerStats.toString())
            apply()
        }
    }

//    fun find(): SuperHero {
//        sharedPref.apply {
//            return SuperHero(
//            getString("id", "")!!,
//            getString("name", "")!!,
//            getString("slug", "")!!
//            )
//        }
//    }

    fun delete() {
        sharedPref.edit().clear().apply()
    }

    fun saveAll(superHeroes: List<SuperHero>) {
        val editor = sharedPref.edit()
        superHeroes.forEach { superHero ->
            editor.putString(superHero.id, gson.toJson(superHero))
        }
        editor.apply()
    }

    fun findAll(): List<SuperHero> {
        val superHeroes = mutableListOf<SuperHero>()
        val mapSuperHeroes = sharedPref.all
        mapSuperHeroes.values.forEach { jsonSuperHero ->
            val superHero = gson.fromJson(jsonSuperHero as String, SuperHero::class.java)
            superHeroes.add(superHero)
        }
        return superHeroes
    }
}

