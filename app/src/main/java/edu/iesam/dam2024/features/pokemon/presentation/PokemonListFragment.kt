package edu.iesam.dam2024.features.pokemon.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import edu.iesam.dam2024.databinding.FragmentPokemonListBinding
import edu.iesam.dam2024.features.pokemon.data.remote.PokemonMockRemoteDataSource
import edu.iesam.dam2024.features.pokemon.domain.Pokemon

class PokemonListFragment : Fragment() {

    private var _binding: FragmentPokemonListBinding? = null
    private val binding get() = _binding!!

    private lateinit var factory: PokemonFactory
    private lateinit var viewModel: PokemonListViewModel

    private val pokemonAdapter = PokemonAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPokemonListBinding.inflate(inflater, container, false)
        setupView()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        factory = PokemonFactory(requireContext())
        viewModel = factory.getPokemonListViewModel()
        viewModel.loadPokemonList()
        setupObserver()
    }

    private fun setupObserver() {
        val observer = Observer<PokemonListViewModel.UiState> { uiState ->
            uiState.pokemons?.let { pokemons ->
                pokemonAdapter.submitList(pokemons)
            }

            uiState.errorApp?.let {
                //pinto el error
            } ?: run {
                //esto es como un else con ScopeFunction
                //Ocultar el error
            }

            if (uiState.isLoading) {
                Log.d("@dev", "Cargando...")
            } else {
                Log.d("@dev", "Cargado")
            }
        }
        viewModel.uiState.observe(viewLifecycleOwner, observer)
    }

    private fun setupView() {
        binding.apply {
            recyclerViewPokemon.layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.VERTICAL,
                false
            )
            recyclerViewPokemon.adapter = pokemonAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}