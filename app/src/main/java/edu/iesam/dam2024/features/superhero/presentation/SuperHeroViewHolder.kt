package edu.iesam.dam2024.features.superhero.presentation

import android.view.View
import androidx.navigation.Navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import edu.iesam.dam2024.app.extensions.loadUrl
import edu.iesam.dam2024.databinding.ViewSuperheroItemBinding
import edu.iesam.dam2024.features.superhero.domain.SuperHero

class SuperHeroViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    private lateinit var binding: ViewSuperheroItemBinding

    fun bind(model: SuperHero) {
        binding = ViewSuperheroItemBinding.bind(view)
        binding.apply {
            image.loadUrl(model.images)
            name.text = model.name
            superheroViewLayout.setOnClickListener {
                navigateToDetails(model.id)
            }
        }
    }

    private fun navigateToDetails(superHeroId: String) {
        findNavController(view).navigate(
            SuperHeroesFragmentDirections.actionSuperheroToSuperheroDetail(superHeroId = superHeroId)
        )
    }
}