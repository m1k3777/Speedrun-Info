package dev.mvillasenor.speedruninfo.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dev.mvillasenor.speedrunapiclient.SpeedrunApiClient
import javax.inject.Singleton

@Module
class SpeedrunClientModule() {

    @Provides
    @Singleton
    fun provideSpeedrunClien(context: Context): SpeedrunApiClient =
        SpeedrunApiClient.Builder(context)
            .build()

}
