package br.com.gustavomonteiro.camararepository.api.model

import br.com.gustavomonteiro.camararepository.model.Deputado
import com.squareup.moshi.Json

data class ResponseDeputadoList(@field:Json(name = "dados") val deputados: List<Deputado>)
