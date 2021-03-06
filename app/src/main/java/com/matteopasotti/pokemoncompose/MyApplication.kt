package com.matteopasotti.pokemoncompose

import android.app.Application
import com.matteopasotti.pokemoncompose.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

open class MyApplication : Application() {
    /**
     * Main dependency component.
     * This will create and provide required dependencies with sub dependencies.
     */
    private val appComponent =
        listOf(databaseModule, viewModelModule, apiModule, repoModule, useCasesModule)

    override fun onCreate() {
        super.onCreate()

        // start Koin context
        startKoin {
            //inject Android context
            androidContext(this@MyApplication)
            // Koin Android logger
            androidLogger()
            // use properties from assets/koin.properties
            androidFileProperties()
            modules(provideDependency())
        }
    }

    open fun provideDependency() = appComponent
}