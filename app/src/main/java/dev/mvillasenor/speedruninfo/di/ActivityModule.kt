package dev.mvillasenor.speedruninfo.di

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dev.mvillasenor.speedruninfo.MainActivity

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract fun contributeSearchActivity(): MainActivity

    @Binds
    abstract fun context(application: Application): Context
}
