package br.com.gustavomonteiro.camararepository.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Deputado(
    val id: Int,
    val uri: String,
    val nome: String,
    val siglaPartido: String,
    val uriPartido: String,
    val siglaUf: String,
    val idLegislatura: String,
    val urlFoto: String,
    val email: String
) : Parcelable