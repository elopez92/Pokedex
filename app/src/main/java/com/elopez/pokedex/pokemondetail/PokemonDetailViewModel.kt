package com.elopez.pokedex.pokemondetail

import androidx.compose.ui.text.toLowerCase
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.elopez.pokedex.data.remote.responses.Pokemon
import com.elopez.pokedex.repository.PokemonRepository
import com.elopez.pokedex.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val repository: PokemonRepository
): ViewModel(), LifecycleObserver {

    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon> {
        return repository.getPokemonInfo(pokemonName)
    }
}