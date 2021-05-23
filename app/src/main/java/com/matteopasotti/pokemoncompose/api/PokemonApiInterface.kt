package com.matteopasotti.pokemoncompose.api

import com.matteopasotti.pokemoncompose.model.Pokemon
import retrofit2.http.GET

interface PokemonApiInterface {

    @GET("pokemon_list")
    suspend fun getPokemonList(): List<Pokemon>
}