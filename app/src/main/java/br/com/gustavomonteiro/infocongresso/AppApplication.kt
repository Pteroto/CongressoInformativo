package br.com.gustavomonteiro.infocongresso

import android.app.Application
import br.com.gustavomonteiro.infocongresso.di.AppComponent
import br.com.gustavomonteiro.infocongresso.di.DaggerAppComponent

class AppApplication: Application() {

    lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()

        component = DaggerAppComponent.builder().build()
    }
}