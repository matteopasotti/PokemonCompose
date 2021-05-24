package com.matteopasotti.pokemoncompose.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.matteopasotti.pokemoncompose.database.dao.PokemonDAO
import com.matteopasotti.pokemoncompose.model.Pokemon

@Database(entities = [(Pokemon::class)], version = 1, exportSchema = false)
@TypeConverters(RoomConverters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun pokemonDao() : PokemonDAO
}