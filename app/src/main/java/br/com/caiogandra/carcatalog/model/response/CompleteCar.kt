package br.com.caiogandra.carcatalog.model.response

import com.google.gson.annotations.SerializedName

data class CompleteCar (
        @SerializedName("codigo_fipe") val fipeCode : String,
        @SerializedName("marca") val brand: String,
        @SerializedName("modelo") val model: String,
        @SerializedName("ano") val year: String,
        @SerializedName("valor") val value: Int
)