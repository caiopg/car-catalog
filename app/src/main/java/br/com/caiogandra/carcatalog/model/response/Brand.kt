package br.com.caiogandra.carcatalog.model.response

import com.google.gson.annotations.SerializedName

data class Brand (
        @SerializedName("marca") val brand : String
)