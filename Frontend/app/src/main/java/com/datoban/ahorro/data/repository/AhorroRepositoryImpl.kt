package com.datoban.ahorro.data.repository

import com.datoban.ahorro.data.remote.ApiService
import com.datoban.ahorro.domain.model.Aporte
import com.datoban.ahorro.domain.model.Meta
import com.datoban.ahorro.domain.model.Miembro
import com.datoban.ahorro.domain.repository.AhorroRepository

class AhorroRepositoryImpl(
    private val api: ApiService
) : AhorroRepository {

    override suspend fun getMiembros(): List<Miembro> =
        api.getMiembros().map { it.toDomain() }

    override suspend fun getMiembroPorId(id: Int): Miembro =
        api.getMiembroPorId(id).toDomain()

    override suspend fun getMiembrosAportantes(): List<Miembro> =
        api.getMiembrosAportantes().map { it.toDomain() }

    override suspend fun getMetas(): List<Meta> =
        api.getMetas().map { it.toDomain() }

    override suspend fun getMetaPorId(id: Int): Meta =
        api.getMetaPorId(id).toDomain()

    override suspend fun getAportes(): List<Aporte> =
        api.getAportes().map { it.toDomain() }

    override suspend fun getAportesPorMeta(metaId: Int): List<Aporte> =
        api.getAportesPorMeta(metaId).map { it.toDomain() }

    override suspend fun getAportesPorMiembro(miembroId: Int): List<Aporte> =
        api.getAportesPorMiembro(miembroId).map { it.toDomain() }

    override suspend fun getTotalConfirmadoPorMeta(metaId: Int): Double =
        api.getTotalConfirmadoPorMeta(metaId).total
}
