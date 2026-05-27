package com.datoban.ahorro.presentacion.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.datoban.ahorro.domain.model.Aporte
import com.datoban.ahorro.domain.repository.AhorroRepository
import kotlinx.coroutines.launch

class AporteViewModel(
    private val repository: AhorroRepository
) : ViewModel() {

    fun registrarAporte(
        metaId: Int,
        miembroId: Int,
        monto: Double,
        metodoPago: String,
        descripcion: String
    ) {

        viewModelScope.launch {

            val aporte = Aporte(
                metaId = metaId,
                miembroId = miembroId,
                monto = monto,
                metodoPago = metodoPago,
                descripcion = descripcion
            )

            repository.registrarAporte(aporte)

        }

    }

}