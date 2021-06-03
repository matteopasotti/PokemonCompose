package com.matteopasotti.pokemoncompose.view

import com.matteopasotti.pokemoncompose.model.Pokemon

class PokemonListUseCase(private val repository: PokemonRepository) {

    suspend fun getPokemonList(): List<Pokemon>? = repository.getPokemonList()
}