package dev.dbserver.model

import com.google.gson.annotations.SerializedName

class Type(

    @SerializedName("results")
    var results : List<Results>
)