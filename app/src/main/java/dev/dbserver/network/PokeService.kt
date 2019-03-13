package dev.dbserver.network

import dev.dbserver.model.Pokemons
import dev.dbserver.model.Type
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PokeService {

    @GET("api/v2/type/")
    fun list() : Call<Type>

    @GET("api/v2/type/{name}")
    fun listType(@Path("name") name : String) : Call<Pokemons>

}