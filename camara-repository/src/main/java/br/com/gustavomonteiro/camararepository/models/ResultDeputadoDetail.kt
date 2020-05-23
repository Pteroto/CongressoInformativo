package br.com.gustavomonteiro.camararepository.models

sealed class ResultDeputadoDetail {
    data class Success(val deputado: DeputadoDetail) : ResultDeputadoDetail()
    data class Error(val errorMsg: String) : ResultDeputadoDetail()
}