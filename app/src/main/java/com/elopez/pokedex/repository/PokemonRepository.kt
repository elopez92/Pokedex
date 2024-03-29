package com.elopez.pokedex.repository

import com.elopez.pokedex.data.remote.PokeApi
import com.elopez.pokedex.data.remote.responses.Pokemon
import com.elopez.pokedex.data.remote.responses.PokemonList
import com.elopez.pokedex.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import java.util.Locale
import javax.inject.Inject

@ActivityScoped
class PokemonRepository @Inject constructor(
    private val api: PokeApi
){

    suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList> {
        val response = try{
            api.getPokemonList(limit, offset)
        } catch (e: Exception){
            return Resource.Error("An unkown error occurred")
        }
        return Resource.Success(response)
    }

    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon> {
        val response = try{
            api.getPokemonInfo(pokemonName.lowercase(Locale.ROOT))
        } catch (e: Exception){
            return Resource.Error("An unkown error occurred. ${e.message}")
        }
        return Resource.Success(response)
    }
}