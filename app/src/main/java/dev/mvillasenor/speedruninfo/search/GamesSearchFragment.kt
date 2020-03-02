package dev.mvillasenor.speedruninfo.ui.search

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.android.support.AndroidSupportInjection
import dev.mvillasenor.speedrunapiclient.models.Game
import dev.mvillasenor.speedruninfo.databinding.FragmentGamesSearchBinding
import dev.mvillasenor.speedruninfo.extensions.observeWith
import dev.mvillasenor.speedruninfo.search.GamesSearchViewModel
import dev.mvillasenor.speedruninfo.search.epoxy.GamesController
import timber.log.Timber
import javax.inject.Inject

class GamesSearchFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by viewModels<GamesSearchViewModel> { viewModelFactory }

    private val gamesController = GamesController()
    private lateinit var binding: FragmentGamesSearchBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGamesSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.searchButton.setOnClickListener {
            viewModel.performSearch(binding.search.text.toString())
        }

        viewModel.games.observeWith(this, this::searchResultsReceived)

        binding.gamesList.adapter = gamesController.adapter
        binding.gamesList.layoutManager = LinearLayoutManager(context)
        binding.gamesList.addItemDecoration(
            DividerItemDecoration(
                context,
                LinearLayoutManager.VERTICAL
            )
        )
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
    }

    private fun searchResultsReceived(gamesResult: Result<List<Game>>) {
        gamesResult.fold(
            {
                Timber.d("Games found: ${it.size}")
                gamesController.setGames(it)
            },
            {
                Timber.e(it, "Error loading games")
                Toast.makeText(requireContext(), "Error performing Search", Toast.LENGTH_LONG)
                    .show()
            }
        )
    }
}
