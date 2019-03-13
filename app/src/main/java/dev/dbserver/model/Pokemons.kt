package dev.dbserver.model

import com.google.gson.annotations.SerializedName

class Pokemons(

    @SerializedName("pokemon")
    var pokemon : List<Pokemon>,

    @SerializedName("slot")
    var slot : Int
)
