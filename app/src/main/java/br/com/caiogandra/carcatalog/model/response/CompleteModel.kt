package br.com.caiogandra.carcatalog.model.response

import com.google.gson.annotations.SerializedName

data class CompleteModel (
        @SerializedName("codigo_fipe") val fipeCode : String,
        @SerializedName("modelo") val model : String,
        @SerializedName("ano") val year : String
)