package dev.mvillasenor.speedruninfo.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.switchMap
import dev.mvillasenor.speedrunapiclient.stores.GamesStore
import javax.inject.Inject

class GamesSearchViewModel @Inject constructor(private val gamesStore: GamesStore) : ViewModel() {

    private val searchQuery = MutableLiveData<String>()
    val games = searchQuery.switchMap {
        liveData {
            val result = kotlin.runCatching {
                gamesStore.performSearch(it)
            }
            emit(result)
        }
    }

    fun performSearch(query: String) {
        searchQuery.postValue(query)
    }
}
