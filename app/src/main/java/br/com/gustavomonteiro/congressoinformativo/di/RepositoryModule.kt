package br.com.gustavomonteiro.congressoinformativo.di

import br.com.gustavomonteiro.congressoinformativo.camararepository.DeputadoRepository
import br.com.gustavomonteiro.congressoinformativo.camararepository.api.ApiBuilder
import br.com.gustavomonteiro.congressoinformativo.camararepository.api.CamaraApi
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {
    @Provides
    fun provideRepository(api: CamaraApi) =
        DeputadoRepository.makeRetrofit(api)

    @Provides
    fun provideApi() =
        ApiBuilder().createApi()
}
