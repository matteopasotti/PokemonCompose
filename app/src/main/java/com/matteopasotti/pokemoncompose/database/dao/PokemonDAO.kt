package com.matteopasotti.pokemoncompose.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.matteopasotti.pokemoncompose.model.Pokemon

@Dao
interface PokemonDAO {
    @Query("SELECT * FROM Pokemon WHERE id = :id")
    fun getById(id: String?): LiveData<Pokemon>

    @Query("SELECT * FROM Pokemon")
    fun all(): List<Pokemon>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(pokemon: List<Pokemon>)
}