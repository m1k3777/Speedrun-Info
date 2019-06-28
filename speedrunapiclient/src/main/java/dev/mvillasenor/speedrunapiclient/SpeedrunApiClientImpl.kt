package dev.mvillasenor.speedrunapiclient

import android.content.Context
import dev.mvillasenor.speedrunapiclient.retrofit.GamesApi
import dev.mvillasenor.speedrunapiclient.stores.GamesStore
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

internal class SpeedrunApiClientImpl(
    context: Context,
    private val baseUrl: String,
    private val cacheSize: Long

): SpeedrunApiClient {

    override val gamesStore: GamesStore by lazy{
        GamesStore(retrofit.create(GamesApi::class.java))
    }

    private val retrofit: Retrofit by lazy {
        val okHttp = OkHttpClient
            .Builder()
            .cache(Cache(context.cacheDir, cacheSize))
            .build()

        Retrofit.Builder()
            .client(okHttp)
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build()
    }
}
