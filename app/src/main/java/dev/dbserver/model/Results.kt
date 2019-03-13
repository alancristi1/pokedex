package dev.dbserver.model

import com.google.gson.annotations.SerializedName

class Results(

    @SerializedName("name")
    var name : String,
    @SerializedName("url")
    var url : String
)