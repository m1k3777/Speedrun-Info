package dev.mvillasenor.speedrunapiclient

import android.content.Context
import dev.mvillasenor.speedrunapiclient.stores.GamesStore

interface SpeedrunApiClient {

    val gamesStore: GamesStore

    /**
     * Builder to obtain an instance of the SpeedrunApiClient
     */
    class Builder(private val context: Context) {

        private var baseUrl: String = "https://www.speedrun.com/api/v1/"
        private var cacheSize: Long = 1024 * 10

        fun setBaseUrl(baseUrl: String): Builder = this.apply {
            this.baseUrl = baseUrl
        }

        fun setCacheSize(cacheSize: Long): Builder = this.apply {
            this.cacheSize = cacheSize
        }

        fun build(): SpeedrunApiClient = SpeedrunApiClientImpl(context, baseUrl, cacheSize)

    }
}
