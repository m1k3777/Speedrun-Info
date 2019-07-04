package dev.mvillasenor.speedruninfo.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule
import dev.mvillasenor.speedruninfo.SpeedrunApplication
import javax.inject.Singleton

@Component(modules = [ActivityModule::class, SpeedrunClientModule::class, ViewModelModule::class, AndroidSupportInjectionModule::class])
@Singleton
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(speedrunApplication: SpeedrunApplication)
}
