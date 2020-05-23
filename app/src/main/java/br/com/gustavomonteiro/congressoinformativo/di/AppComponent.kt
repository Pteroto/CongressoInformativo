package br.com.gustavomonteiro.congressoinformativo.di

import br.com.gustavomonteiro.congressoinformativo.ui.main.MainFragment
import dagger.Component

@Component(modules = [RepositoryModule::class, MainFragmentModule::class])
interface AppComponent {

    fun inject(mainFragment: MainFragment)

    @Component.Builder
    interface Builder {
        fun build(): AppComponent
    }
}