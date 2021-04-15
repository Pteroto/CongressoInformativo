package br.com.gustavomonteiro.camararepository.api

import br.com.gustavomonteiro.camararepository.api.model.ResponseDeputado
import br.com.gustavomonteiro.camararepository.api.model.ResponseDeputadoList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CamaraApi {
    @GET("deputados/{id}")
    fun getDeputado(@Path("id") id: String? = null): Call<ResponseDeputado>

    @GET("deputados")
    fun getDeputados(): Call<ResponseDeputadoList>

    @GET("deputados")
    suspend fun getNewDeputados(): ResponseDeputadoList
}
