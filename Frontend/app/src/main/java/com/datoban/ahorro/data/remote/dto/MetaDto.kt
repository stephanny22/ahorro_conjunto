package com.datoban.ahorro.data.remote.dto

import com.google.gson.annotations.SerializedName

data class MetaDto(
    @SerializedName("id")               val id: Int,
    @SerializedName("nombre")           val nombre: String,
    @SerializedName("descripcion")      val descripcion: String,
    @SerializedName("valor_total")      val valorTotal: Double,
    @SerializedName("fechaObjetivo")    val fechaObjetivo: String,
    @SerializedName("ubicacionImagen")  val ubicacionImagen: String,
    @SerializedName("estado")           val estado: String,
    @SerializedName("fechaCreacion")    val fechaCreacion: String
)
