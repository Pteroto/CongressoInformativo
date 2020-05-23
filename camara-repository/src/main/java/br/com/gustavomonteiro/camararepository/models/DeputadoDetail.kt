package br.com.gustavomonteiro.camararepository.models

data class DeputadoDetail(
    val id: Int,
    val cpf: String,
    val dataFalescimento: String,
    val dataNascimento: String,
    val escolaridade: String,
    val municipioNascimento: String,
    val nomeCivil: String,
    val redeSocial: List<String>,
    val sexo: String,
    val ufNascimento: String,
    val ultimoStatus: Status,
    val uri: String,
    val urlWebsite: String
)