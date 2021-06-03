package com.matteopasotti.pokemoncompose.view

import com.matteopasotti.pokemoncompose.api.PokemonApiInterface
import com.matteopasotti.pokemoncompose.database.dao.PokemonDAO
import com.matteopasotti.pokemoncompose.model.Pokemon
import org.koin.core.component.KoinComponent


interface PokemonRepository {
    suspend fun getPokemonList(): List<Pokemon>?
}

internal class PokemonRepositoryImpl(
    private val apiService: PokemonApiInterface,
    private val pokemonDao: PokemonDAO
) : PokemonRepository, KoinComponent {

    override suspend fun getPokemonList(): List<Pokemon>? {
        val items = pokemonDao.all()
        if(items.isNullOrEmpty()) {
            val pokemons = apiService.getPokemonList()
            if(!pokemons.isNullOrEmpty()) {
                pokemonDao.add(pokemons)
                return pokemons
            }
        }
        return items
    }
}