package edu.iesam.dam2024.features.superhero.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import edu.iesam.dam2024.app.extensions.loadUrl
import edu.iesam.dam2024.databinding.FragmentSuperheroDetailBinding
import edu.iesam.dam2024.features.superhero.domain.SuperHero

class SuperHeroDetailFragment : Fragment() {

    private lateinit var superHeroFactory: SuperHeroFactory
    private lateinit var viewModel: SuperHeroDetailViewModel

    private var _binding: FragmentSuperheroDetailBinding? = null
    private val binding get() = _binding!!

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
        return "1"
    }

    private fun bindData(superhero: SuperHero) {
        binding.image.loadUrl(superhero.image.lg)
    }

//    companion object {
//        const val KEY_SUPERHERO_ID = "key_superhero_id"
//
//        fun getIntent(context: Context, superHeroId: String): Intent {
//            val intent = Intent(context, SuperHeroDetailActivity::class.java)
//            intent.putExtra(KEY_SUPERHERO_ID, superHeroId)
//            return intent
//        }
//    }
}