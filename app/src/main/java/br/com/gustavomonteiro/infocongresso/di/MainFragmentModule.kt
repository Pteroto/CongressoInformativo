package br.com.gustavomonteiro.infocongresso.di

import br.com.gustavomonteiro.camararepository.DeputadoRepository
import br.com.gustavomonteiro.infocongresso.ui.main.viewmodel.MainViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MainFragmentModule {
    @Provides
    fun provideMainViewModelFactory(repository: DeputadoRepository) =
        MainViewModelFactory(repository)
}