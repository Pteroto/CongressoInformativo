package br.com.gustavomonteiro.camararepository.model

data class Status(
    val condicaoEleitoral: String,
    val data: String,
    val descricaoStatus: String,
    val email: String,
    val gabinete: Gabinete,
    val id: Int,
    val idLegislatura: Int,
    val nome: String,
    val nomeEleitoral: String,
    val siglaPartido: String,
    val siglaUf: String,
    val situacao: String,
    val uri: String,
    val uriPartido: String,
    val uriFoto: String
)