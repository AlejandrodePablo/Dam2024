package edu.iesam.dam2024.features.superhero.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import edu.iesam.dam2024.app.domain.ErrorApp
import edu.iesam.dam2024.databinding.FragmentSuperheroesBinding
import edu.iesam.dam2024.features.superhero.domain.SuperHero

class SuperHeroesFragment : Fragment() {
    private lateinit var superHeroFactory: SuperHeroFactory
    private lateinit var viewModel: SuperHeroesViewModel

    private var _binding: FragmentSuperheroesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSuperheroesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        superHeroFactory = SuperHeroFactory(requireContext())
        viewModel = superHeroFactory.buildViewModel()
        viewModel.viewCreated()
        setupObserver()
    }

    private fun setupObserver() {
        val movieObserver = Observer<SuperHeroesViewModel.UiState> { uiState ->
            uiState.superHeroes?.let {
                bindData(it)
            }
            uiState.errorApp?.let {
                //pinto el error
            } ?: kotlin.run {
                //ocultar error
            }
            if (uiState.isLoading) {
                Log.d("@dev", "Cargando...")
            } else {
                Log.d("@dev", "Cargado")
            }
        }
        viewModel.uiState.observe(viewLifecycleOwner, movieObserver)
    }


    private fun bindData(superHeroes: List<SuperHero>) {
        binding.apply {
            superheroId1.apply {
                text = superHeroes[0].id
            }
            superheroName1.apply {
                text = superHeroes[0].name
                setOnClickListener {
                    navigateToDetails(superHeroes[0].id)
                }
            }
            superheroId2.apply {
                text = superHeroes[1].id
            }
            superheroName2.apply {
                text = superHeroes[1].name
                setOnClickListener {
                    navigateToDetails(superHeroes[1].id)
                }
            }
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

    private fun navigateToDetails(superHeroId: String) {

        findNavController().navigate(
            SuperHeroesFragmentDirections.actionSuperheroToSuperheroDetail(
                superHeroId
            )
        )

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}