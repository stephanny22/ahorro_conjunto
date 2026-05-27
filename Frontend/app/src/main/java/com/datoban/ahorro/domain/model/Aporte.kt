package com.datoban.ahorro.domain.model

data class Aporte(
    val id: Int,
    val metaId: Int,
    val miembroId: Int,
    val monto: Double,
    val metodoPago: String,
    val descripcion: String,
    val fecha: String,
    val estado: String
)
