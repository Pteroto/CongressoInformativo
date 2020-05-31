package br.com.gustavomonteiro.infocongresso.di

import br.com.gustavomonteiro.deputado.di.DeputadoComponent
import dagger.Module

@Module(subcomponents = [DeputadoComponent::class])
class SubComponentsModule {}