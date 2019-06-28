package dev.mvillasenor.speedrunapiclient.stores

import dev.mvillasenor.speedrunapiclient.models.Game
import dev.mvillasenor.speedrunapiclient.retrofit.GamesApi

class GamesStore (val gamesApi: GamesApi) {

    suspend fun performSearch(query: String): List<Game> {
        return gamesApi.search(query).data
    }

}
