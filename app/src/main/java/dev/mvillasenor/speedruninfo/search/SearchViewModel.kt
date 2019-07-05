package dev.mvillasenor.speedruninfo.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.mvillasenor.speedrunapiclient.models.Game
import dev.mvillasenor.speedrunapiclient.stores.GamesStore
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

class SearchViewModel @Inject constructor(private val gamesStore: GamesStore) : ViewModel() {

    private val _games = MutableLiveData<Result<List<Game>>>()
    val games get() = _games as LiveData<Result<List<Game>>>

    fun performSearch(query: String) {
        viewModelScope.launch {
            val result = runCatching {
                gamesStore.performSearch(query).apply {
                    Timber.d("the size is ${this.size}")
                }
            }

            _games.postValue(result)
        }
    }

}
