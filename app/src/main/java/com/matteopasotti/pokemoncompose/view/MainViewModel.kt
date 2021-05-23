package com.matteopasotti.pokemoncompose.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.matteopasotti.pokemoncompose.model.Pokemon
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val pokemonListUseCase: PokemonListUseCase): ViewModel() {

    private val _pokemonList: MutableLiveData<List<Pokemon>> = MutableLiveData()
    val pokemonList: LiveData<List<Pokemon>> = _pokemonList

    fun getPokemonList() {
        viewModelScope.launch(Dispatchers.IO) {
            _pokemonList.postValue(pokemonListUseCase.getPokemonList(20))
        }
    }
}