package com.matteopasotti.pokemoncompose.api.response

import com.matteopasotti.pokemoncompose.model.Pokemon

data class PokemonListResponse(
    val count: Int? = null,
    val results: ArrayList<Pokemon>? = null
)