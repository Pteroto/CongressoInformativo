package br.com.gustavomonteiro.deputado.di

import br.com.gustavomonteiro.deputado.ui.DeputadoHomeFragment
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [RepositoryModule::class, DeputadoModule::class])
interface DeputadoComponent {

    @Subcomponent.Builder
    interface Builder {
        fun build(): DeputadoComponent
    }

    fun inject(deputadoHomeFragment: DeputadoHomeFragment)
}
