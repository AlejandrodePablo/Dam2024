package edu.iesam.dam2024.features.pokemon.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import edu.iesam.dam2024.app.extensions.loadUrl
import edu.iesam.dam2024.databinding.FragmentPokemonDetailBinding
import edu.iesam.dam2024.features.pokemon.domain.Pokemon

class PokemonDetailFragment : Fragment() {

    private lateinit var factory: PokemonFactory
    private lateinit var viewModel: PokemonDetailViewModel

    private var _binding: FragmentPokemonDetailBinding? = null
    private val binding get() = _binding!!

    private val pokemonArgs: PokemonDetailFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPokemonDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        factory = PokemonFactory(requireContext())
        viewModel = factory.buildPokemonDetailViewModel()
        getPokemonId().let {
            viewModel.viewCreated(it)
        }
        setupObserver()
        pokemonArgs.pokemonId

    }

    private fun setupObserver() {
        val observer = Observer<PokemonDetailViewModel.UiState> { uiState ->
            uiState.pokemon?.let {
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
        viewModel.uiState.observe(viewLifecycleOwner, observer)
    }


    private fun getPokemonId(): String {
        return pokemonArgs.pokemonId
    }

    private fun bindData(pokemon: Pokemon) {
        binding.apply {
            name.text = pokemon.name
            pokemonId.text = pokemon.id
            image.loadUrl(pokemon.image)
            height.text = pokemon.height
            move.text = pokemon.move
            weight.text = pokemon.weight
        }
    }
}