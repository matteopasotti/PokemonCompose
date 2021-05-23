package com.matteopasotti.pokemoncompose.di

import com.matteopasotti.pokemoncompose.view.PokemonRepository
import com.matteopasotti.pokemoncompose.view.PokemonRepositoryImpl
import org.koin.dsl.module

val repoModule = module {
    single<PokemonRepository> { PokemonRepositoryImpl(apiService = get()) }
}