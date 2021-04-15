package br.com.gustavomonteiro.camararepository.model

sealed class ResultDeputadoDetail {
    data class Success(val deputado: DeputadoDetail) : ResultDeputadoDetail()
    data class Error(val errorMsg: String) : ResultDeputadoDetail()
}