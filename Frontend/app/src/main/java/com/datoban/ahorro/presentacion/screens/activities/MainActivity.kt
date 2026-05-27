package com.datoban.ahorro.presentacion.screens.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.datoban.ahorro.data.remote.RetrofitInstance
import com.datoban.ahorro.data.repository.AhorroRepositoryImpl
import com.datoban.ahorro.presentacion.screens.navigation.AppNavigation

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val repo = AhorroRepositoryImpl(api = RetrofitInstance.api)

        setContent {

            var conexion          by remember { mutableStateOf("Cargando...") }
            var miembros          by remember { mutableStateOf("Cargando...") }
            var miembrosAportantes by remember { mutableStateOf("Cargando...") }
            var metas             by remember { mutableStateOf("Cargando...") }
            var aportesMeta1      by remember { mutableStateOf("Cargando...") }
            var totalMeta1        by remember { mutableStateOf("Cargando...") }

            LaunchedEffect(Unit) {
                conexion = try {
                    RetrofitInstance.api.ping().mensaje
                } catch (e: Exception) { "Error: ${e.message}" }

                miembros = try {
                    repo.getMiembros()
                        .joinToString("\n") { "• ${it.idMiembro} — ${it.nombre}" }
                } catch (e: Exception) { "Error: ${e.message}" }

                miembrosAportantes = try {
                    repo.getMiembrosAportantes()
                        .joinToString("\n") { "• ${it.idMiembro} — ${it.nombre}" }
                } catch (e: Exception) { "Error: ${e.message}" }

                metas = try {
                    repo.getMetas()
                        .joinToString("\n") { "• [${it.id}] ${it.nombre} | $${it.valorTotal} | ${it.estado}" }
                } catch (e: Exception) { "Error: ${e.message}" }

                aportesMeta1 = try {
                    repo.getAportesPorMeta(1)
                        .joinToString("\n") { "• aporte ${it.id} — $${it.monto} (${it.estado})" }
                } catch (e: Exception) { "Error: ${e.message}" }

                totalMeta1 = try {
                    "$${repo.getTotalConfirmadoPorMeta(1)}"
                } catch (e: Exception) { "Error: ${e.message}" }
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Seccion("Conexión",            conexion)
                Seccion("Miembros",            miembros)
                Seccion("Miembros aportantes", miembrosAportantes)
                Seccion("Metas",               metas)
                Seccion("Aportes meta 1",      aportesMeta1)
                Seccion("Total confirmado meta 1", totalMeta1)
            }
        }
    }
}

@Composable
private fun Seccion(titulo: String, contenido: String) {
    Text(text = "▶ $titulo", fontSize = 14.sp)
    Text(text = contenido,   fontSize = 12.sp)
}