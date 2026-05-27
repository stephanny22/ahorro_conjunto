package com.datoban.ahorro.presentacion.screens.metas

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun MisMetasScreen(navController: NavController) {

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate("crearMeta")
                }
            ) {
                Text("+")
            }
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {

            Text(
                text = "Mis Metas",
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(modifier = Modifier.height(20.dp))

            Card(
                onClick = {
                    navController.navigate("detalleMeta")
                }
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text("Fondo para Televisor 55''")
                    Text("$3.000.000")
                    LinearProgressIndicator(progress = { 0.40f })
                }
            }
        }
    }
}