package edu.iesam.dam2024.features.pokemon.presentation

import android.view.View
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import edu.iesam.dam2024.app.extensions.loadUrl
import edu.iesam.dam2024.databinding.FragmentPokemonDetailBinding
import edu.iesam.dam2024.databinding.ViewPokemonItemBinding
import edu.iesam.dam2024.features.pokemon.domain.Pokemon

class PokemonViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    private lateinit var binding: ViewPokemonItemBinding

    fun bind(model: Pokemon) {
        binding = ViewPokemonItemBinding.bind(view)
        binding.apply {
            image.loadUrl(model.image)
            name.text = model.name
            pokemonViewLayout.setOnClickListener {
                navigateToDetails(model.id)
            }
        }
    }

    private fun navigateToDetails(pokemonId: String) {
        findNavController(view).navigate(
            PokemonListFragmentDirections.actionFromPkmnToPkmnDetail(pokemonId)
        )
    }

}