package br.com.gustavomonteiro.camararepository.device

import androidx.lifecycle.LiveData

interface NetworkHandler {
    fun isConnected(): LiveData<Boolean>
}