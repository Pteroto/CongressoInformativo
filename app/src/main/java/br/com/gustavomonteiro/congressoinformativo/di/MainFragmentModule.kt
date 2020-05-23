package br.com.gustavomonteiro.congressoinformativo.di

import br.com.gustavomonteiro.congressoinformativo.camararepository.DeputadoRepository
import br.com.gustavomonteiro.congressoinformativo.ui.main.viewmodel.MainViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MainFragmentModule {
    @Provides
    fun provideMainViewModelFactory(repository: DeputadoRepository) =
        MainViewModelFactory(repository)
}