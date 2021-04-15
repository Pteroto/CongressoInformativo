package br.com.gustavomonteiro.camararepository.model

sealed class ResultDeputadoRequest {
    data class Success(val deputadoList: List<Deputado>) : ResultDeputadoRequest()
    data class Failure(val errorMsg: String) : ResultDeputadoRequest()
    data class Loading(val status: Boolean): ResultDeputadoRequest()
}