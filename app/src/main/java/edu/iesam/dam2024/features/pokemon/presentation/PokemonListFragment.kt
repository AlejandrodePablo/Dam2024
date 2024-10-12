package edu.iesam.dam2024.features.pokemon.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import edu.iesam.dam2024.databinding.FragmentPokemonListBinding
import edu.iesam.dam2024.features.pokemon.domain.Pokemon

class PokemonListFragment : Fragment() {

    private var _binding: FragmentPokemonListBinding? = null
    private val binding get() = _binding!!

    private lateinit var factory: PokemonFactory
    private lateinit var viewModel: PokemonListViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPokemonListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        factory = PokemonFactory(requireContext())
        viewModel = factory.getPokemonListViewModel()
        setupObserver()
        viewModel.loadPokemonList()
    }

    private fun setupObserver() {
        val observer = Observer<PokemonListViewModel.UiState> { uiState ->
            uiState.pokemons?.let { pokemons ->
                binData(pokemons)
            }

            uiState.errorApp?.let {
                //pinto el error
            } ?: run {
                //esto es como un else con ScopeFunction
                //Ocultar el error
            }

            if (uiState.isLoading) {
                //Muestra cargando
            } else {
                //Oculto mensaje
            }
        }
        viewModel.uiState.observe(viewLifecycleOwner, observer)
    }

    private fun binData(pokemons: List<Pokemon>) {

        binding.apply {
            pkmn1.apply {
                text = pokemons[0].name
                setOnClickListener {
                    navigateToDetails(pokemons[0].id)
                }
            }
        }

        binding.apply {
            pkmn2.apply {
                text = pokemons[1].name
                setOnClickListener {
                    navigateToDetails(pokemons[1].id)
                }
            }
        }

        binding.apply {
            pkmn3.apply {
                text = pokemons[2].name
                setOnClickListener {
                    navigateToDetails(pokemons[2].id)
                }
            }
        }
    }

    private fun navigateToDetails(pokemonId: String) {
        findNavController().navigate(
            PokemonListFragmentDirections.actionFromPkmnToPkmnDetail(pokemonId)
        )
    }
}