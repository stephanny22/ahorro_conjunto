package com.datoban.ahorro.presentacion.screens.metas

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun DetalleMetaScreen(
    navController: NavController,
    metaId: Int
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "Detalle Meta #$metaId",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Meta: $3.000.000"
        )

        LinearProgressIndicator(
            progress = { 0.40f }
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                navController.navigate("aporte")
            }
        ) {
            Text(
                text = "Realizar aporte"
            )
        }
    }
}
