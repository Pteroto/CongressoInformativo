package br.com.gustavomonteiro.camararepository.di

import br.com.gustavomonteiro.camararepository.DeputadoRepository
import br.com.gustavomonteiro.camararepository.api.ApiBuilder
import br.com.gustavomonteiro.camararepository.api.CongressmanApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Provides
    fun provideRepository(api: CongressmanApi) =
        DeputadoRepository.makeRetrofit(api)

    @Singleton
    @Provides
    fun provideRetrofit() = ApiBuilder().createRetrofit()

    @Provides
    fun provideCongressmanApi(retrofit: Retrofit) =
        ApiBuilder().createCongressmanApi(retrofit)

    @Provides
    fun provideVotesApi(retrofit: Retrofit) =
        ApiBuilder().createVotesApi(retrofit)
}
