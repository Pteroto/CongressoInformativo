package br.com.gustavomonteiro.camararepository

import br.com.gustavomonteiro.camararepository.api.CamaraApi
import br.com.gustavomonteiro.camararepository.api.DeputadoRetrofitImpl
import br.com.gustavomonteiro.camararepository.model.ResultDeputadoDetail
import br.com.gustavomonteiro.camararepository.model.ResultDeputadoRequest
import kotlinx.coroutines.flow.Flow

interface DeputadoRepository {
    suspend fun getDeputado(id: String): ResultDeputadoDetail
    suspend fun getDeputados(): ResultDeputadoRequest
    suspend fun getNewDeputados(): Flow<ResultDeputadoRequest>

    companion object Factory {
        fun makeRetrofit(api: CamaraApi): DeputadoRepository {
            return DeputadoRetrofitImpl(api)
        }
    }
}
