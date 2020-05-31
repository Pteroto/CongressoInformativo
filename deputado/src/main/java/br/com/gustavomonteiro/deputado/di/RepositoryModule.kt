package br.com.gustavomonteiro.deputado.di

import br.com.gustavomonteiro.camararepository.DeputadoRepository
import br.com.gustavomonteiro.camararepository.api.ApiBuilder
import br.com.gustavomonteiro.camararepository.api.CamaraApi
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
