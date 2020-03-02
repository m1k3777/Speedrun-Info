package dev.mvillasenor.speedruninfo.di

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dev.mvillasenor.speedruninfo.ui.main.MainActivity
import dev.mvillasenor.speedruninfo.ui.search.GamesSearchFragment

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun contributeSearchFragment(): GamesSearchFragment

    @Binds
    abstract fun context(application: Application): Context
}
