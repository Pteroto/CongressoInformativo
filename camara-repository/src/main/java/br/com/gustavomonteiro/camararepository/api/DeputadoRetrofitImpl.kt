package br.com.gustavomonteiro.camararepository.api

import br.com.gustavomonteiro.camararepository.DeputadoRepository
import br.com.gustavomonteiro.camararepository.models.ResultDeputadoDetail
import br.com.gustavomonteiro.camararepository.models.ResultDeputadoList

@Suppress("BlockingMethodInNonBlockingContext") //Bug https://youtrack.jetbrains.com/issue/KT-30320
class DeputadoRetrofitImpl(private val api: CamaraApi) : DeputadoRepository {
    override suspend fun getDeputado(id: String): ResultDeputadoDetail {
        try {
            val response = api.getDeputado(id).execute()
            response.body()?.let {
                when {
                    response.isSuccessful ->
                        return ResultDeputadoDetail.Success(it.deputado)
                    else -> ResultDeputadoDetail.Error(UNKNOWN_ERROR_MSG)
                }
            } ?: return ResultDeputadoDetail.Error(DEPUTADO_NOT_FOUND_MSG)
        } catch (exception: Exception) {
            ResultDeputadoDetail.Error("Error msg: ${exception.message ?: DEPUTADO_NOT_FOUND_MSG}")
        }

        return ResultDeputadoDetail.Error(UNKNOWN_ERROR_MSG)
    }

    override suspend fun getDeputados(): ResultDeputadoList {
        try {
            val response = api.getDeputados().execute()
            response.body()?.let {
                when {
                    response.isSuccessful -> return ResultDeputadoList.Success(it.deputados)
                    else -> ResultDeputadoDetail.Error(UNKNOWN_ERROR_MSG)
                }
            } ?: ResultDeputadoDetail.Error(UNKNOWN_ERROR_MSG)
        } catch (exception: Exception) {
            ResultDeputadoDetail.Error("Error msg: ${exception.message ?: DEPUTADO_NOT_FOUND_MSG}")
        }

        return ResultDeputadoList.Failure(UNKNOWN_ERROR_MSG)
    }

    companion object {
        private const val UNKNOWN_ERROR_MSG = "Unknown Error"
        private const val DEPUTADO_NOT_FOUND_MSG = "Deputado not found"
    }
}