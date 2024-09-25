package edu.iesam.dam2024.feature.superhero.presentation

import androidx.lifecycle.ViewModel
import edu.iesam.dam2024.feature.superhero.domain.GetSuperHeroUseCase
import edu.iesam.dam2024.feature.superhero.domain.GetSuperHeroesUseCase
import edu.iesam.dam2024.feature.superhero.domain.SuperHero

class SuperHeroViewModel(
    private val getSuperHeroesUseCase: GetSuperHeroesUseCase,
    private val getSuperHeroUseCase: GetSuperHeroUseCase
) : ViewModel() {

    fun viewCreated(): List<SuperHero> {
        return getSuperHeroesUseCase.invoke()
    }

    fun itemSelected(superHeroId: String): SuperHero? {
        return getSuperHeroUseCase.invoke(superHeroId)
    }
}