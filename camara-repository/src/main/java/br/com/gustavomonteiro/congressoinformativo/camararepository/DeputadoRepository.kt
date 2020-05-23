package br.com.gustavomonteiro.congressoinformativo.camararepository

import br.com.gustavomonteiro.congressoinformativo.camararepository.api.CamaraApi
import br.com.gustavomonteiro.congressoinformativo.camararepository.api.DeputadoRetrofitImpl
import br.com.gustavomonteiro.congressoinformativo.camararepository.models.ResultDeputadoDetail
import br.com.gustavomonteiro.congressoinformativo.camararepository.models.ResultDeputadoList

interface DeputadoRepository {
    suspend fun getDeputado(id: String): ResultDeputadoDetail
    suspend fun getDeputados(): ResultDeputadoList

    companion object Factory {
        fun makeRetrofit(api: CamaraApi) : DeputadoRepository{
            return DeputadoRetrofitImpl(api)
        }
    }
}