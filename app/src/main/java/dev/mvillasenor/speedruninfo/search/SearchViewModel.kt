package dev.mvillasenor.speedruninfo.search

import android.util.Log
import androidx.lifecycle.ViewModel
import dev.mvillasenor.speedrunapiclient.SpeedrunApiClient
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class SearchViewModel @Inject constructor(val speedrunApiClient: SpeedrunApiClient) : ViewModel() {

    fun test(query: String) {
        GlobalScope.launch {
            speedrunApiClient.gamesStore.performSearch(query).apply {
                Log.d("test", "the size is ${this.size}")
            }
        }
    }

}
