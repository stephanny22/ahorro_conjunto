package com.datoban.ahorro.data.remote.dto

import com.google.gson.annotations.SerializedName

data class MiembroDto(
    @SerializedName("id_miembro")    val idMiembro: Int,
    @SerializedName("Nombre")        val nombre: String,
    @SerializedName("fechaCreacion") val fechaCreacion: String
)
