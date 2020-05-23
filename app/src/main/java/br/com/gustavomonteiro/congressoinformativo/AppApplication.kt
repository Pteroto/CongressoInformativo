package br.com.gustavomonteiro.congressoinformativo

import android.app.Application
import br.com.gustavomonteiro.congressoinformativo.di.AppComponent
import br.com.gustavomonteiro.congressoinformativo.di.DaggerAppComponent

class AppApplication: Application() {

    lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()

        component = DaggerAppComponent.builder().build()
    }
}