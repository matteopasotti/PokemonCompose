package com.matteopasotti.pokemoncompose.di

import com.matteopasotti.pokemoncompose.view.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        MainViewModel(pokemonListUseCase = get())
    }
}