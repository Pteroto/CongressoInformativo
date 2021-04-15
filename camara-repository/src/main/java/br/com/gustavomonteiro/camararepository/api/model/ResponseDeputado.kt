package br.com.gustavomonteiro.camararepository.api.model

import br.com.gustavomonteiro.camararepository.model.DeputadoDetail
import com.squareup.moshi.Json

data class ResponseDeputado(@field:Json(name = "dados") val deputado: DeputadoDetail)
