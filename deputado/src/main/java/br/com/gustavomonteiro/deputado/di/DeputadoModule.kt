package br.com.gustavomonteiro.deputado.di

import br.com.gustavomonteiro.camararepository.DeputadoRepository
import br.com.gustavomonteiro.deputado.presentation.factory.DeputadoHomeViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class DeputadoModule {
    @Provides
    fun provideDeputadoHomeViewModelFactory(repository: DeputadoRepository) =
        DeputadoHomeViewModelFactory(repository)
}
