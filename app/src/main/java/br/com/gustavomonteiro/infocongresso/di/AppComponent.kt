package br.com.gustavomonteiro.infocongresso.di

import br.com.gustavomonteiro.deputado.di.DeputadoComponent
import dagger.Component

@Component(modules = [SubComponentsModule::class])
interface AppComponent {

    @Component.Builder
    interface Builder {
        fun build(): AppComponent
    }

    fun deputadoComponent(): DeputadoComponent.Builder
}
