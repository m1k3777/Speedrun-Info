package dev.mvillasenor.speedruninfo.search

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.android.AndroidInjection
import dev.mvillasenor.speedrunapiclient.models.Game
import dev.mvillasenor.speedruninfo.R
import dev.mvillasenor.speedruninfo.extensions.observeWith
import dev.mvillasenor.speedruninfo.search.epoxy.GamesController
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber
import javax.inject.Inject

class SearchActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by viewModels<SearchViewModel> { viewModelFactory }

    private val gamesController = GamesController()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        AndroidInjection.inject(this)

        searchButton.setOnClickListener {
            viewModel.performSearch(search.text.toString())
        }

        viewModel.games.observeWith(this, this::searchResultsReceived)

        gamesList.adapter = gamesController.adapter
        gamesList.layoutManager = LinearLayoutManager(this)
        gamesList.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
    }

    private fun searchResultsReceived(gamesResult: Result<List<Game>>) {
        gamesResult.fold(
            {
                Timber.d("Games found: ${it.size}")
                gamesController.setGames(it)
            },
            {
                Timber.e(it, "Error loading games")
                Toast.makeText(this, "Error performing Search", Toast.LENGTH_LONG).show()
            }
        )

    }
}
