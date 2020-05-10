package br.com.gustavomonteiro.congressoinformativo.ui.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.gustavomonteiro.congressoinformativo.camararepository.api.ApiBuilder
import br.com.gustavomonteiro.congressoinformativo.camararepository.api.DeputadoRetrofitImpl
import br.com.gustavomonteiro.congressoinformativo.camararepository.models.DeputadoDetail
import br.com.gustavomonteiro.congressoinformativo.camararepository.models.ResultDeputadoDetail
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val internalDeputado = MutableLiveData<DeputadoDetail>()
    val deputado: LiveData<DeputadoDetail>
        get() = internalDeputado

    private val internalError = MutableLiveData<String>()
    val error: LiveData<String>
        get() = internalError

    fun getDeputado(id: String) {
        val api = DeputadoRetrofitImpl(ApiBuilder().createApi())
        viewModelScope.launch(Dispatchers.IO) {
            val deputadoId = if (id.isNotBlank()) id else "9999"
            when (val result = api.getDeputado(deputadoId)) {
                is ResultDeputadoDetail.Success -> internalDeputado.postValue(result.deputado)
                is ResultDeputadoDetail.Error -> internalError.postValue(result.errorMsg)
            }
        }
    }
}
