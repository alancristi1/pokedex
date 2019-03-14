package dev.dbserver.model
import com.google.gson.annotations.SerializedName


data class ListPokeType(
    @SerializedName("damage_relations")
    val damageRelations: DamageRelations,
    @SerializedName("game_indices")
    val gameIndices: List<Any>,
    @SerializedName("generation")
    val generation: Generation,
    @SerializedName("id")
    val id: Int,
    @SerializedName("move_damage_class")
    val moveDamageClass: MoveDamageClass,
    @SerializedName("moves")
    val moves: List<Any>,
    @SerializedName("name")
    val name: String,
    @SerializedName("names")
    val names: List<Any>,
    @SerializedName("pokemon")
    val pokemon: List<Pokemon>
)

data class Pokemon(
    @SerializedName("pokemon")
    val pokemon: PokemonX,
    @SerializedName("slot")
    val slot: Int
)

data class PokemonX(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)

class DamageRelations(
)

class Generation()

data class MoveDamageClass(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)