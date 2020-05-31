package br.com.gustavomonteiro.camararepository.api

import br.com.gustavomonteiro.camararepository.DeputadoRepository
import br.com.gustavomonteiro.camararepository.models.ResultDeputadoDetail
import br.com.gustavomonteiro.camararepository.models.ResultDeputadoList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.flowOn

@Suppress("BlockingMethodInNonBlockingContext") //Bug https://youtrack.jetbrains.com/issue/KT-30320
class DeputadoRetrofitImpl(private val api: CamaraApi) : DeputadoRepository {
    override suspend fun getDeputado(id: String): ResultDeputadoDetail {
        try {
            val response = api.getDeputado(id).execute()
            response.body()?.let {
                return when {
                    response.isSuccessful ->
                        ResultDeputadoDetail.Success(it.deputado)
                    else -> ResultDeputadoDetail.Error(UNKNOWN_ERROR_MSG)
                }
            } ?: return ResultDeputadoDetail.Error(DEPUTADO_NOT_FOUND_MSG)
        } catch (exception: Exception) {
            return ResultDeputadoDetail.Error("Error msg: ${exception.message ?: DEPUTADO_NOT_FOUND_MSG}")
        }
    }

    override suspend fun getDeputados(): ResultDeputadoList {
        try {
            val response = api.getDeputados().execute()
            response.body()?.let {
                return when {
                    response.isSuccessful -> ResultDeputadoList.Success(it.deputados)
                    else -> ResultDeputadoList.Failure(UNKNOWN_ERROR_MSG)
                }
            } ?: return ResultDeputadoList.Failure(UNKNOWN_ERROR_MSG)
        } catch (exception: Exception) {
            return ResultDeputadoList.Failure("Error msg: ${exception.message ?: DEPUTADO_NOT_FOUND_MSG}")
        }
    }

    @ExperimentalCoroutinesApi
    override suspend fun getNewDeputados(): Flow<ResultDeputadoList> {
        return flowOf(
            try {
                ResultDeputadoList.Success(api.getNewDeputados().deputados)
            } catch (exception: Exception) {
                ResultDeputadoList.Failure("Error msg: ${exception.message ?: UNKNOWN_ERROR_MSG}")
            }
        ).flowOn(Dispatchers.IO)
    }

    companion object {
        private const val UNKNOWN_ERROR_MSG = "Unknown Error"
        private const val DEPUTADO_NOT_FOUND_MSG = "Deputado not found"
    }
}