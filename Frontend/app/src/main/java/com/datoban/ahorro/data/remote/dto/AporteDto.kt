package com.datoban.ahorro.data.remote.dto

import com.google.gson.annotations.SerializedName

data class AporteDto(
    @SerializedName("id")          val id: Int,
    @SerializedName("metaId")      val metaId: Int,
    @SerializedName("miembroId")   val miembroId: Int,
    @SerializedName("monto")       val monto: Double,
    @SerializedName("metodoPago")  val metodoPago: String,
    @SerializedName("descripcion") val descripcion: String,
    @SerializedName("fecha")       val fecha: String,
    @SerializedName("estado")      val estado: String
)