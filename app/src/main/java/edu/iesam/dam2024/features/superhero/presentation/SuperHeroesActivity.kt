package edu.iesam.dam2024.features.superhero.presentation

import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import edu.iesam.dam2024.R
import edu.iesam.dam2024.app.domain.ErrorApp
import edu.iesam.dam2024.features.superhero.data.local.SuperHeroXmlLocalDataSource
import edu.iesam.dam2024.features.superhero.domain.SuperHero

class SuperHeroesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_superheroes)

    }


//    private fun testXml() {
//        val xmlDataSource = SuperHeroXmlLocalDataSource(this)
//        val superHero = viewModel.viewCreated()
//        superHero.let { superHero->
//            xmlDataSource.save(superHero)
//        }
//
//        val superHeroSaved = xmlDataSource.findById("1")
//        Log.d("@dev", superHeroSaved.toString())
//    }

//    private fun testXmlList() {
//        val superHeroes = viewModel.viewCreated()
//        val xmlDataSource = SuperHeroXmlLocalDataSource(this)
//        xmlDataSource.saveAll(superHeroes)
//
//        val superHeroesFromXml = xmlDataSource.findAll()
//        Log.d("@dev", "$superHeroesFromXml")
//    }
}