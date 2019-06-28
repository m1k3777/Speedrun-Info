package dev.mvillasenor.speedruninfo.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dev.mvillasenor.speedruninfo.di.viewmodel.ViewModelFactory
import dev.mvillasenor.speedruninfo.di.viewmodel.ViewModelKey
import dev.mvillasenor.speedruninfo.search.SearchViewModel

@Module
internal abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(SearchViewModel::class)
    protected abstract fun searchViewModel(searchViewModel: SearchViewModel): ViewModel


}
