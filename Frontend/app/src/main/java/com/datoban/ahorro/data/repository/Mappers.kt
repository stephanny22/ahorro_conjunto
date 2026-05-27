package com.datoban.ahorro.data.repository

import com.datoban.ahorro.data.remote.dto.AporteDto
import com.datoban.ahorro.data.remote.dto.MetaDto
import com.datoban.ahorro.data.remote.dto.MiembroDto
import com.datoban.ahorro.domain.model.Aporte
import com.datoban.ahorro.domain.model.Meta
import com.datoban.ahorro.domain.model.Miembro

fun MiembroDto.toDomain() = Miembro(
    idMiembro     = idMiembro,
    nombre        = nombre,
    fechaCreacion = fechaCreacion
)

fun MetaDto.toDomain() = Meta(
    id              = id,
    nombre          = nombre,
    descripcion     = descripcion,
    valorTotal      = valorTotal,
    fechaObjetivo   = fechaObjetivo,
    ubicacionImagen = ubicacionImagen,
    estado          = estado,
    fechaCreacion   = fechaCreacion
)

fun AporteDto.toDomain() = Aporte(
    id          = id,
    metaId      = metaId,
    miembroId   = miembroId,
    monto       = monto,
    metodoPago  = metodoPago,
    descripcion = descripcion,
    fecha       = fecha,
    estado      = estado
)
