package com.datoban.ahorro.data.remote

import com.datoban.ahorro.data.remote.dto.AporteDto
import com.datoban.ahorro.data.remote.dto.MetaDto
import com.datoban.ahorro.data.remote.dto.MiembroDto
import com.datoban.ahorro.data.remote.dto.RespuestaDto
import com.datoban.ahorro.data.remote.dto.TotalAporteDto
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    // ── verificarConexion ──────────────────────────────────────────────────────────────────
    @GET("/")
    suspend fun verificarConexion(): RespuestaDto

    // ── Miembros ──────────────────────────────────────────────────────────────
    /** Equivale a: SELECT * FROM miembros */
    @GET("/miembros")
    suspend fun getMiembros(): List<MiembroDto>

    /** Equivale a: SELECT * FROM miembros WHERE id_miembro = :id */
    @GET("/miembros/{id}")
    suspend fun getMiembroPorId(@Path("id") id: Int): MiembroDto

    /** Equivale a: SELECT DISTINCT miembros WHERE id IN (SELECT miembroId FROM aportes) */
    @GET("/miembros/aportantes")
    suspend fun getMiembrosAportantes(): List<MiembroDto>

    // ── Metas ─────────────────────────────────────────────────────────────────
    /** Equivale a: SELECT * FROM metas */
    @GET("/metas")
    suspend fun getMetas(): List<MetaDto>

    /** Equivale a: SELECT * FROM metas WHERE id = :id */
    @GET("/metas/{id}")
    suspend fun getMetaPorId(@Path("id") id: Int): MetaDto

    // ── Aportes ───────────────────────────────────────────────────────────────
    /** Equivale a: SELECT * FROM aportes */
    @GET("/aportes")
    suspend fun getAportes(): List<AporteDto>

    /** Equivale a: SELECT * FROM aportes WHERE metaId = :metaId */
    @GET("/aportes/meta/{metaId}")
    suspend fun getAportesPorMeta(@Path("metaId") metaId: Int): List<AporteDto>

    /** Equivale a: SELECT * FROM aportes WHERE miembroId = :miembroId */
    @GET("/aportes/miembro/{miembroId}")
    suspend fun getAportesPorMiembro(@Path("miembroId") miembroId: Int): List<AporteDto>

    /** Equivale a: SELECT SUM(monto) FROM aportes WHERE metaId = :id AND estado = 'confirmado' */
    @GET("/aportes/meta/{metaId}/total")
    suspend fun getTotalConfirmadoPorMeta(@Path("metaId") metaId: Int): TotalAporteDto
}
