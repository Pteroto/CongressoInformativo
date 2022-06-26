package br.com.gustavomonteiro.camararepository.api

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class ApiBuilder {
    private val baseURL = "https://dadosabertos.camara.leg.br/api/v2/"

    fun createRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

    fun createCongressmanApi(retrofit: Retrofit): CongressmanApi =
        retrofit.create(CongressmanApi::class.java)

    fun createVotesApi(retrofit: Retrofit): PollApi =
        retrofit.create(PollApi::class.java)
}
