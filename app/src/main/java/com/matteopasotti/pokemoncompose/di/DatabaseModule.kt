package com.matteopasotti.pokemoncompose.di

import androidx.room.Room
import com.matteopasotti.pokemoncompose.R
import com.matteopasotti.pokemoncompose.database.AppDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(
            androidApplication(),
            AppDatabase::class.java,
            androidApplication().baseContext.getString(R.string.app_name)
        ).build()
    }

    single {
        get<AppDatabase>().pokemonDao()
    }
}