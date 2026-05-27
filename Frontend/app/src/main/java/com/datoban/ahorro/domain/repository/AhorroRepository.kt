package com.datoban.ahorro.domain.repository

import com.datoban.ahorro.domain.model.Aporte
import com.datoban.ahorro.domain.model.Meta
import com.datoban.ahorro.domain.model.Miembro

interface AhorroRepository {
    suspend fun getMiembros(): List<Miembro>
    suspend fun getMiembroPorId(id: Int): Miembro
    suspend fun getMiembrosAportantes(): List<Miembro>

    suspend fun getMetas(): List<Meta>
    suspend fun getMetaPorId(id: Int): Meta

    suspend fun getAportes(): List<Aporte>
    suspend fun getAportesPorMeta(metaId: Int): List<Aporte>
    suspend fun getAportesPorMiembro(miembroId: Int): List<Aporte>
    suspend fun getTotalConfirmadoPorMeta(metaId: Int): Double
}
