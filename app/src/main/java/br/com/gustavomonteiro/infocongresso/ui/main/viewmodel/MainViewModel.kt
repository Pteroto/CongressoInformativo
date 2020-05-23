package br.com.gustavomonteiro.infocongresso.ui.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.gustavomonteiro.camararepository.DeputadoRepository
import br.com.gustavomonteiro.camararepository.models.DeputadoDetail
import br.com.gustavomonteiro.camararepository.models.ResultDeputadoDetail
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val repository: DeputadoRepository) : ViewModel() {
    private val internalDeputado = MutableLiveData<DeputadoDetail>()
    val deputado: LiveData<DeputadoDetail>
        get() = internalDeputado

    private val internalError = MutableLiveData<String>()
    val error: LiveData<String>
        get() = internalError

    fun getDeputado(id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val deputadoId = if (id.isNotBlank()) id else "9999"
            when (val result = repository.getDeputado(deputadoId)) {
                is ResultDeputadoDetail.Success -> internalDeputado.postValue(result.deputado)
                is ResultDeputadoDetail.Error -> internalError.postValue(result.errorMsg)
            }
        }
    }
}
