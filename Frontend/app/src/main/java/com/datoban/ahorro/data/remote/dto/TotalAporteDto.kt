package com.datoban.ahorro.data.remote.dto

import com.google.gson.annotations.SerializedName

data class TotalAporteDto(
    @SerializedName("metaId") val metaId: Int,
    @SerializedName("total")  val total: Double
)
