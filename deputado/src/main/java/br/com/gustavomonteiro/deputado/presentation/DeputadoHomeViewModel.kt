package br.com.gustavomonteiro.deputado.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.gustavomonteiro.camararepository.DeputadoRepository
import br.com.gustavomonteiro.camararepository.model.ResultDeputadoRequest
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

@HiltViewModel
class DeputadoHomeViewModel @Inject constructor(
    private val repository: DeputadoRepository
) : ViewModel() {

    private val internalRequestResult = MutableLiveData<ResultDeputadoRequest>()
    val requestResult: LiveData<ResultDeputadoRequest>
        get() = internalRequestResult

    init {
        getDeputados()
    }

    private fun getDeputados() {
        viewModelScope.launch {
            repository.getNewDeputados().onStart {
                emit(ResultDeputadoRequest.Loading(true))
            }.catch {
                emit(ResultDeputadoRequest.Failure("Error: ${it.message}"))
            }.collect {
                internalRequestResult.value = it
            }
        }
    }

    fun retryOnClick() {
        getDeputados()
    }
}
