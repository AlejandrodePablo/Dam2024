package edu.iesam.dam2024.features.superhero.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import edu.iesam.dam2024.app.extensions.loadUrl
import edu.iesam.dam2024.databinding.FragmentSuperheroDetailBinding
import edu.iesam.dam2024.features.superhero.domain.SuperHero

class SuperHeroDetailFragment : Fragment() {

    private lateinit var superHeroFactory: SuperHeroFactory
    private lateinit var viewModel: SuperHeroDetailViewModel

    private var _binding: FragmentSuperheroDetailBinding? = null
    private val binding get() = _binding!!

    private val superheroArgs: SuperHeroDetailFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSuperheroDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        superHeroFactory = SuperHeroFactory(requireContext())
        viewModel = superHeroFactory.buildSuperHeroDetailViewModel()
        getSuperHeroId()?.let {
            viewModel.viewCreated(it)
        }
        setupObserver()
        superheroArgs.superHeroId
    }

    private fun setupObserver() {
        val superHeroObserver = Observer<SuperHeroDetailViewModel.UiState> { uiState ->
            uiState.superHero?.let {
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
        viewModel.uiState.observe(viewLifecycleOwner, superHeroObserver)
    }

    private fun getSuperHeroId(): String? {
        return superheroArgs.superHeroId
    }

    private fun bindData(superhero: SuperHero) {
        binding.apply {
//            ivSuperHeroImage.loadUrl(superhero.images.xs)
            tvSuperHeroName.text = superhero.name
            tvSuperHeroId.text = superhero.id
            tvSuperHeroSlug.text = superhero.slug
        }
    }

}