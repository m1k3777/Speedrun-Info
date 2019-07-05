package dev.mvillasenor.speedruninfo.search

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.android.AndroidInjection
import dev.mvillasenor.speedrunapiclient.models.Game
import dev.mvillasenor.speedruninfo.R
import dev.mvillasenor.speedruninfo.extensions.observeWith
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.FlowPreview
import timber.log.Timber
import javax.inject.Inject

class SearchActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: SearchViewModel

    @FlowPreview
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        AndroidInjection.inject(this)

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(SearchViewModel::class.java)

        searchButton.setOnClickListener {
            viewModel.performSearch(search.text.toString())
        }

        viewModel.games.observeWith(this, this::searchResultsReceived)
    }

    private fun searchResultsReceived(gamesResult: Result<List<Game>>) {
        gamesResult
            .onSuccess {
                Timber.d("Games found: ${it.size}")
            }
            .onFailure {
                Timber.e(it, "Error loading games")
                Toast.makeText(this, "Error performing Search", Toast.LENGTH_LONG).show()
            }

    }
}
