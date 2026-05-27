package com.datoban.ahorro.presentacion.screens.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.datoban.ahorro.data.remote.retrofitInstance

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            var mensaje by remember {
                mutableStateOf("Cargando...")
            }

            LaunchedEffect(Unit) {
                try {
                    val respuesta = retrofitInstance.api.verificarConexion()
                    mensaje = respuesta.mensaje
                } catch (e: Exception) {
                    mensaje = "Error: ${e.message}"
                }
            }

            Text(text = mensaje)
        }
    }
}