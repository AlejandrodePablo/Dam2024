package edu.iesam.dam2024.features.superhero.data.local

import android.content.Context
import com.google.gson.Gson
import edu.iesam.dam2024.features.superhero.domain.Appearance
import edu.iesam.dam2024.features.superhero.domain.Biography
import edu.iesam.dam2024.features.superhero.domain.Connections
import edu.iesam.dam2024.features.superhero.domain.PowerStats
import edu.iesam.dam2024.features.superhero.domain.SuperHero
import edu.iesam.dam2024.features.superhero.domain.Work

class SuperHeroXmlLocalDataSource(private val context: Context) {

    private val sharedPref = context.getSharedPreferences(
        "superheroes", Context.MODE_PRIVATE
    )

    private val gson = Gson()

//    fun save(superHero: SuperHero) {
//        sharedPref.edit().apply {
//            putString("id", superHero.id)
//            putString("name", superHero.name)
//            putString("slug", superHero.slug)
//            putString("work", superHero.work.toString())
//            putString("appearance", superHero.appearance.toString())
//            putString("biography", superHero.biography.toString())
//            putString("connections", superHero.connections.toString())
//            putString("powerStats", superHero.powerStats.toString())
//            apply()
//        }
//    }

    fun save(superHero: SuperHero) {
        val editor = sharedPref.edit()
        // Convertimos el superhéroe completo a JSON
        val superHeroJson = gson.toJson(superHero)
        // Guardamos el JSON bajo la clave del ID del superhéroe
        editor.putString(superHero.id, superHeroJson)
        editor.apply()
    }


//    fun find(): SuperHero {
//
//        sharedPref.apply {
//
//            //Primero convertimos los JSON almacenados de vuelta a objetos
//            val powerStatsJson = getString("powerStats", "")!!
//            val appearanceJson = getString("appearance", "")!!
//            val biographyJson = getString("biography", "")!!
//            val workJson = getString("work", "")!!
//            val connectionsJson = getString("connections", "")!!
//            val imagesJson = getString("images", "")!!
//
//            //Deserializamos los datos con Gson
//            val powerStats = gson.fromJson(powerStatsJson, PowerStats::class.java)
//            val appearance = gson.fromJson(appearanceJson, Appearance::class.java)
//            val biography = gson.fromJson(biographyJson, Biography::class.java)
//            val work = gson.fromJson(workJson, Work::class.java)
//            val connections = gson.fromJson(connectionsJson, Connections::class.java)
//          val images = gson.fromJson(imagesJson, Image::class.java)
//
//            return SuperHero(
//                id = getString("id", "")!!,
//                name = getString("name", "")!!,
//                slug = getString("slug", "")!!,
//                work = work,
//                appearance = appearance,
//                biography = biography,
//                connections = connections,
//                powerStats = powerStats,
//                images = images
//            )
//        }
//    }

    fun findById(superHeroId: String): SuperHero? {
        return sharedPref.getString(superHeroId, null).let { superHero ->
            gson.fromJson(superHero, SuperHero::class.java)
        }
    }

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

