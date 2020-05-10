package br.com.gustavomonteiro.congressoinformativo.camararepository.device

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities.NET_CAPABILITY_INTERNET
import android.net.NetworkRequest
import androidx.lifecycle.LiveData

class NetworkHandlerImpl(context: Context) : NetworkHandler {
    private val connMgr =  context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    private object Singleton {
        val Instance = ConnectionLiveData()
    }

    companion object {
        val instance: ConnectionLiveData by lazy { Singleton.Instance }
    }

    override fun isConnected(): LiveData<Boolean> {
        return instance
    }

    class ConnectionLiveData() : LiveData<Boolean>() {
        private val networkRequest = NetworkRequest.Builder()
            .addCapability(NET_CAPABILITY_INTERNET)
            .build()
        private val networkCallback = object : ConnectivityManager.NetworkCallback() {
            override fun onAvailable(network: Network) {
                super.onAvailable(network)
                postValue(true)
            }

            override fun onUnavailable() {
                super.onUnavailable()
                postValue(false)
            }
        }

        override fun onActive() {
            super.onActive()
            //connMgr.registerNetworkCallback(networkRequest, networkCallback)
        }

        override fun onInactive() {
            super.onInactive()
            try {
                //connMgr.unregisterNetworkCallback(networkCallback)
            } catch (e: Exception) {
            }
        }
    }
}