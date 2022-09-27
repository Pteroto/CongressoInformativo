package br.com.gustavomonteiro.camararepository.api

import br.com.gustavomonteiro.camararepository.api.model.ResponseDeputadoList
import retrofit2.http.GET
import retrofit2.http.Path

interface PollApi {
    @GET("votacoes")
    suspend fun getPolls(): ResponseDeputadoList

    @GET("votacoes/{id}")
    suspend fun getPollsById(@Path("id") id: String): ResponseDeputadoList

    @GET("votacoes/{id}/orientacoes")
    suspend fun getPollsOrientation(): ResponseDeputadoList

    @GET("votacoes/{id}/votos")
    suspend fun getVotes(): ResponseDeputadoList
}
