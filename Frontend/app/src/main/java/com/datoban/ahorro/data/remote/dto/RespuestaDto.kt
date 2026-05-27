package com.datoban.ahorro.data.remote.dto

import com.google.gson.annotations.SerializedName

data class RespuestaDto(
    @SerializedName("mensaje") val mensaje: String
)
