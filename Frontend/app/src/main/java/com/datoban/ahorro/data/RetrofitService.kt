package com.datoban.ahorro.data

import com.datoban.ahorro.models.Respuesta
import retrofit2.http.GET

interface RetrofitService {
    @GET("/")
    suspend fun verificarConexion(): Respuesta
}