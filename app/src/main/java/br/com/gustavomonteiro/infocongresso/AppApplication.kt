package br.com.gustavomonteiro.infocongresso

import android.app.Application
import br.com.gustavomonteiro.deputado.di.DeputadoComponent
import br.com.gustavomonteiro.deputado.di.DeputadoComponentProvider
import br.com.gustavomonteiro.infocongresso.di.AppComponent
import br.com.gustavomonteiro.infocongresso.di.DaggerAppComponent

class AppApplication : Application(), DeputadoComponentProvider {

    lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()

        component = DaggerAppComponent.builder().build()
    }

    override fun provideDeputadoComponent(): DeputadoComponent {
        return component.deputadoComponent().build()
    }
}
