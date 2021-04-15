package br.com.gustavomonteiro.camararepository.api

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class ApiBuilder {
    private val baseURL = "https://dadosabertos.camara.leg.br/api/v2/"

    fun createApi(): CamaraApi {
        val retrofit = Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
        return retrofit.create(CamaraApi::class.java)
    }
}
