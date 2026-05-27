package com.datoban.ahorro.domain.model

data class Meta(
    val id: Int,
    val nombre: String,
    val descripcion: String,
    val valorTotal: Double,
    val fechaObjetivo: String,
    val ubicacionImagen: String,
    val estado: String,
    val fechaCreacion: String
)