package dev.mvillasenor.speedruninfo.di

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dev.mvillasenor.speedruninfo.search.SearchActivity

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract fun contributeSearchActivity(): SearchActivity

    @Binds
    abstract fun context(application: Application): Context
}
