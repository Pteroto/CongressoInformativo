package br.com.gustavomonteiro.deputado.presentation.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.gustavomonteiro.camararepository.DeputadoRepository
import br.com.gustavomonteiro.deputado.presentation.DeputadoHomeViewModel

class DeputadoHomeViewModelFactory(private val repository: DeputadoRepository) :
    ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(DeputadoHomeViewModel::class.java)) {
            DeputadoHomeViewModel(repository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}