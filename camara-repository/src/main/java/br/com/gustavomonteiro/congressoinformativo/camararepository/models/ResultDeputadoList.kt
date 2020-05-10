package br.com.gustavomonteiro.congressoinformativo.camararepository.models

sealed class ResultDeputadoList {
    data class Success(val deputadoList: List<Deputado>) : ResultDeputadoList()
    data class Failure(val errorMsg: String) : ResultDeputadoList()
}