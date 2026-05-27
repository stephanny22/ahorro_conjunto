package com.datoban.ahorro.presentacion.screens.metas

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun DetalleMetaScreen(navController: NavController, id_meta: Int) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            "Fondo para Televisor",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text("Meta: $3.000.000")

        LinearProgressIndicator(
            progress = { 0.40f }
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                navController.navigate("realizarAporte")
            }
        ) {
            Text("Realizar aporte")
        }
    }
}