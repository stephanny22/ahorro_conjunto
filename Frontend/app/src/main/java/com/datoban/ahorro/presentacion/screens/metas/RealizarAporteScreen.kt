package com.datoban.ahorro.presentacion.screens.metas

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun RealizarAporteScreen(navController: NavController) {

    var aporte by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            "Realizar Aporte",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = aporte,
            onValueChange = { aporte = it },
            label = { Text("Monto") }
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = { }
        ) {
            Text("Confirmar aporte")
        }
    }
}