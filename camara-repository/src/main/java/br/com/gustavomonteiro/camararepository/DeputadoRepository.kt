package br.com.gustavomonteiro.camararepository

import br.com.gustavomonteiro.camararepository.api.CamaraApi
import br.com.gustavomonteiro.camararepository.api.DeputadoRetrofitImpl
import br.com.gustavomonteiro.camararepository.models.ResultDeputadoDetail
import br.com.gustavomonteiro.camararepository.models.ResultDeputadoList
import kotlinx.coroutines.flow.Flow

interface DeputadoRepository {
    suspend fun getDeputado(id: String): ResultDeputadoDetail
    suspend fun getDeputados(): ResultDeputadoList
    suspend fun getNewDeputados(): Flow<ResultDeputadoList>

    companion object Factory {
        fun makeRetrofit(api: CamaraApi) : DeputadoRepository{
            return DeputadoRetrofitImpl(api)
        }
    }
}