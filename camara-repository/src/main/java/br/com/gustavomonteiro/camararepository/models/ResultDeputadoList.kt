package br.com.gustavomonteiro.camararepository.models

sealed class ResultDeputadoList {
    data class Success(val deputadoList: List<Deputado>) : ResultDeputadoList()
    data class Failure(val errorMsg: String) : ResultDeputadoList()
    data class Loading(val status: Boolean): ResultDeputadoList()
}