package com.matteopasotti.pokemoncompose.api

import com.matteopasotti.pokemoncompose.api.response.PokemonListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface PokemonApiInterface {

    @GET("pokemon")
    suspend fun getPokemonList(@Query("limit") limit: Int): PokemonListResponse
}