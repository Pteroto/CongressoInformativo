package br.com.gustavomonteiro.congressoinformativo.camararepository

import br.com.gustavomonteiro.congressoinformativo.camararepository.models.ResultDeputadoDetail
import br.com.gustavomonteiro.congressoinformativo.camararepository.models.ResultDeputadoList

interface DeputadoRepository {
    suspend fun getDeputado(id: String): ResultDeputadoDetail
    suspend fun getDeputados(): ResultDeputadoList
}