package dev.mvillasenor.speedrunapiclient.models

data class Game(
    val id: String,
    val names: GameNames,
    val abbreviation: String,
    val assets: Map<String, GameAssets>
)

data class GameNames(
    val international: String?,
    val japanese: String?,
    val twitch: String?
)

data class GameAssets(
    val uri: String,
    val width: Int,
    val height: Int
)


