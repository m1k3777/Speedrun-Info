package dev.mvillasenor.speedruninfo.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dev.mvillasenor.speedrunapiclient.SpeedrunApiClient
import dev.mvillasenor.speedrunapiclient.stores.GamesStore
import javax.inject.Singleton

@Module
class SpeedrunClientModule {

    @Provides
    @Singleton
    fun provideSpeedrunClient(context: Context): SpeedrunApiClient =
        SpeedrunApiClient.Builder(context)
            .build()
    @Provides
    @Singleton
    fun providesGamesStore(speedrunApiClient: SpeedrunApiClient) : GamesStore = speedrunApiClient.gamesStore

}
