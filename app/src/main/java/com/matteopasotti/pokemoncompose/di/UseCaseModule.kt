package com.matteopasotti.pokemoncompose.di

import com.matteopasotti.pokemoncompose.view.PokemonListUseCase
import org.koin.dsl.module

val useCasesModule = module {
    factory { PokemonListUseCase(repository = get()) }
}
