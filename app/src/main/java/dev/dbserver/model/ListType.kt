package dev.dbserver.model
import com.google.gson.annotations.SerializedName


data class ListType(
    @SerializedName("count")
    val count: Int,
    @SerializedName("next")
    val next: Any,
    @SerializedName("previous")
    val previous: Any,
    @SerializedName("results")
    val results: List<Result>
)

data class Result(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)