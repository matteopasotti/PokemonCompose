package com.matteopasotti.pokemoncompose.di

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.matteopasotti.pokemoncompose.api.PokemonApiInterface
import com.matteopasotti.pokemoncompose.di.DatasourceProperties.SERVER_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

val apiModule = module {
    // provided web components
    single { createOkHttpClient() }

    // Fill property
    single { createWebService<PokemonApiInterface>(get(), getProperty(SERVER_URL)) }

}

object DatasourceProperties {
    const val SERVER_URL = "SERVER_URL"
}

fun createOkHttpClient(): OkHttpClient {
    val httpLoggingInterceptor = HttpLoggingInterceptor()
    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
    return OkHttpClient.Builder()
        .connectTimeout(60L, TimeUnit.SECONDS)
        .readTimeout(60L, TimeUnit.SECONDS)
        .addInterceptor(httpLoggingInterceptor).build()
}

inline fun <reified T> createWebService(okHttpClient: OkHttpClient, url: String): T {
    val retrofit = Retrofit.Builder()
        .baseUrl(url)
        .client(okHttpClient)
        .addConverterFactory(MoshiConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory()).build()

    return retrofit.create(T::class.java)
}