package br.com.gustavomonteiro.congressoinformativo.camararepository.models

sealed class ResultDeputadoDetail {
    data class Success(val deputado: DeputadoDetail) : ResultDeputadoDetail()
    data class Error(val errorMsg: String) : ResultDeputadoDetail()
}