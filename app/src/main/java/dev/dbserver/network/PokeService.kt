package dev.dbserver.network

import dev.dbserver.model.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PokeService {

    @GET("api/v2/type/")
    fun list() : Call<ListType>

    @GET("api/v2/type/{name}")
    fun listType(@Path("name") name : String) : Call<ListPokeType>

    @GET("api/v2/pokemon/{name}")
    fun getInfoPoke(@Path("name") name : String) : Call<DetailsPoke>

}