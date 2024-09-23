package edu.iesam.dam2024.feature.superhero.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import edu.iesam.dam2024.R
import edu.iesam.dam2024.feature.superhero.domain.SuperHero

class SuperHeroActivity : AppCompatActivity() {
    private val superHeroFactory: SuperHeroFactory = SuperHeroFactory()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_superhero)
        val viewModel = superHeroFactory.buildViewModel()
        val superHeroes = viewModel.viewCreated()
        Log.d("dev", superHeroes.toString())
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }
}