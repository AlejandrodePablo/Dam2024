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

    private lateinit var superHeroFactory: SuperHeroFactory
    private lateinit var viewModel: SuperHeroesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_superheroes)
        superHeroFactory = SuperHeroFactory(this)
        viewModel = superHeroFactory.buildViewModel()
        setupObserver()
        viewModel.viewCreated()
//        testXmlList()
    }

    private fun setupObserver() {
        val movieObserver = Observer<SuperHeroesViewModel.UiState> { uiState ->
            uiState.superHeroes?.let {
                bindData(it)
            }
            uiState.errorApp?.let {
                //pinto el error
            }
            if (uiState.isLoading) {
                Log.d("@dev", "Cargando...")
            } else {
                Log.d("@dev", "Cargado")
            }
        }
        viewModel.uiState.observe(this, movieObserver)
    }


    private fun bindData(superHeroes: List<SuperHero>) {
        findViewById<TextView>(R.id.superhero_id_1).text = superHeroes[0].id
        findViewById<TextView>(R.id.superhero_name_1).text = superHeroes[0].name
        findViewById<LinearLayout>(R.id.layout1_superhero).setOnClickListener {
            navigateToSuperHeroDetail(superHeroes[0].id)
        }

        findViewById<TextView>(R.id.superhero_id_2).text = superHeroes[1].id
        findViewById<TextView>(R.id.superhero_name_2).text = superHeroes[1].name
        findViewById<LinearLayout>(R.id.layout2_superhero).setOnClickListener {
            navigateToSuperHeroDetail(superHeroes[1].id)
        }
    }

    private fun showError(error: ErrorApp) {
        when (error) {
            ErrorApp.DataErrorApp -> TODO()
            ErrorApp.InternetErrorApp -> TODO()
            ErrorApp.ServerErrorApp -> TODO()
            ErrorApp.UnknowErrorApp -> TODO()
        }

    }

    private fun navigateToSuperHeroDetail(superHeroId: String) {
        startActivity(SuperHeroDetailActivity.getIntent(this, superHeroId))
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