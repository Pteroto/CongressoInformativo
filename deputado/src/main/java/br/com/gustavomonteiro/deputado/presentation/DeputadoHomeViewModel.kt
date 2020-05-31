package br.com.gustavomonteiro.deputado.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import br.com.gustavomonteiro.camararepository.DeputadoRepository
import br.com.gustavomonteiro.camararepository.models.ResultDeputadoList
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart

class DeputadoHomeViewModel(private val repository: DeputadoRepository) : ViewModel() {
    //https://proandroiddev.com/kotlin-flow-on-android-quick-guide-76667e872166

    @ExperimentalCoroutinesApi
    val deputadosList: LiveData<ResultDeputadoList> = liveData {
        repository.getNewDeputados().onStart {
            emit(ResultDeputadoList.Loading(true))
        }.catch {
            emit(ResultDeputadoList.Failure("Error: ${it.message}"))
        }.collect {
            emit(ResultDeputadoList.Loading(false))
            emit(it)
        }
    }
}