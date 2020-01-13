package dev.mvillasenor.speedruninfo.search.epoxy

import com.airbnb.epoxy.EpoxyController
import dev.mvillasenor.speedrunapiclient.models.Game

class GamesController: EpoxyController() {
    private var games = listOf<Game>()

    fun setGames(newGames: List<Game>) {
        games = newGames

        requestModelBuild()
    }

    override fun buildModels() {
        games.forEach {
            game {
                id(it.id)
                name(it.names.international ?: "")
                logoUrl(it.assets["cover-large"]?.uri ?: "")
            }
        }
    }
}
