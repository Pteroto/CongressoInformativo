package br.com.gustavomonteiro.camararepository.models

data class Deputado(
    val id: Int,
    val nome: String,
    val email: String,
    val idLegislatura: String,
    val siglaPartido: String,
    val siglaUf: String,
    val uri: String,
    val uriPartido: String,
    val urlFoto: String
)