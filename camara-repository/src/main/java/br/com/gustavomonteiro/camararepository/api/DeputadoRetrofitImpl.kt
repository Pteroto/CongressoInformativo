package br.com.gustavomonteiro.camararepository.api

import br.com.gustavomonteiro.camararepository.DeputadoRepository
import br.com.gustavomonteiro.camararepository.models.ResultDeputadoDetail
import br.com.gustavomonteiro.camararepository.models.ResultDeputadoRequest
import kotlinx.coroutines.Dispatchers
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

    override suspend fun getDeputados(): ResultDeputadoRequest {
        try {
            val response = api.getDeputados().execute()
            response.body()?.let {
                return when {
                    response.isSuccessful -> ResultDeputadoRequest.Success(it.deputados)
                    else -> ResultDeputadoRequest.Failure(UNKNOWN_ERROR_MSG)
                }
            } ?: return ResultDeputadoRequest.Failure(UNKNOWN_ERROR_MSG)
        } catch (exception: Exception) {
            return ResultDeputadoRequest.Failure("Error msg: ${exception.message ?: DEPUTADO_NOT_FOUND_MSG}")
        }
    }

    override suspend fun getNewDeputados(): Flow<ResultDeputadoRequest> {
        return flowOf(
            try {
                ResultDeputadoRequest.Success(api.getNewDeputados().deputados)
            } catch (exception: Exception) {
                ResultDeputadoRequest.Failure("Error msg: ${exception.message ?: UNKNOWN_ERROR_MSG}")
            }
        ).flowOn(Dispatchers.IO)
    }

    companion object {
        private const val UNKNOWN_ERROR_MSG = "Unknown Error"
        private const val DEPUTADO_NOT_FOUND_MSG = "Deputado not found"
    }
}