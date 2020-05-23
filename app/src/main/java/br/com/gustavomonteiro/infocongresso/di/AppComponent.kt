package br.com.gustavomonteiro.infocongresso.di

import br.com.gustavomonteiro.infocongresso.ui.main.MainFragment
import dagger.Component

@Component(modules = [RepositoryModule::class, MainFragmentModule::class])
interface AppComponent {

    fun inject(mainFragment: MainFragment)

    @Component.Builder
    interface Builder {
        fun build(): AppComponent
    }
}