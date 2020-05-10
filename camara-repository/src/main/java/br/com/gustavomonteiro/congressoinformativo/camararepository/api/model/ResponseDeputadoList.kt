package br.com.gustavomonteiro.congressoinformativo.camararepository.api.model

import br.com.gustavomonteiro.congressoinformativo.camararepository.models.Deputado
import com.squareup.moshi.Json

data class ResponseDeputadoList(@field:Json(name = "dados") val deputados: List<Deputado>)