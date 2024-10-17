package edu.iesam.dam2024.features.pokemon.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import edu.iesam.dam2024.R
import edu.iesam.dam2024.features.pokemon.domain.Pokemon

class PokemonAdapter() : ListAdapter<Pokemon, PokemonViewHolder>(PokemonDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.view_pokemon_item, parent, false)
        return PokemonViewHolder(view)
    }

    override fun getItemCount(): Int = currentList.size

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        holder.bind(currentList[position])
    }
}