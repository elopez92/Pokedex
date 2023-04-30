package com.elopez.pokedex.di

import com.elopez.pokedex.data.remote.PokeApi
import com.elopez.pokedex.repository.PokemonRepository
import com.elopez.pokedex.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providePokemonRepository(
        api: PokeApi
    ) = PokemonRepository(api)

    @Singleton
    @Provides
    fun providePokeApi(client: OkHttpClient) : PokeApi{
        return Retrofit.Builder()
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(PokeApi::class.java)
    }

    @Provides
    @Singleton
    internal fun client(connectivityInterceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(connectivityInterceptor.setLevel(HttpLoggingInterceptor.Level.HEADERS))
            .build()

    @Provides
    @Singleton
    internal fun interceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor()
}

