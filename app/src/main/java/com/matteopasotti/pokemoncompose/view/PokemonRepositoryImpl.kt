package com.matteopasotti.pokemoncompose.view

import com.matteopasotti.pokemoncompose.api.PokemonApiInterface
import com.matteopasotti.pokemoncompose.model.Pokemon


interface PokemonRepository {
    suspend fun getPokemonList(limit: Int) : List<Pokemon>?
}

class PokemonRepositoryImpl(private val apiService: PokemonApiInterface): PokemonRepository {

    override suspend fun getPokemonList(limit: Int): List<Pokemon>? {
        return apiService.getPokemonList(limit).results
    }
}