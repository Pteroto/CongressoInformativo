package br.com.gustavomonteiro.congressoinformativo.camararepository.api.model

import br.com.gustavomonteiro.congressoinformativo.camararepository.models.DeputadoDetail
import com.squareup.moshi.Json

data class ResponseDeputado(@field:Json(name = "dados") val deputado: DeputadoDetail)