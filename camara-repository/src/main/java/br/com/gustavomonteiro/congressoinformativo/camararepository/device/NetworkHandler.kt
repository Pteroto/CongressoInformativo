package br.com.gustavomonteiro.congressoinformativo.camararepository.device

import androidx.lifecycle.LiveData

interface NetworkHandler {
    fun isConnected(): LiveData<Boolean>
}