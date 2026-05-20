package com.datoban.ahorro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.lifecycle.lifecycleScope
import com.datoban.ahorro.Instances.retrofitInstance
import kotlinx.coroutines.launch

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