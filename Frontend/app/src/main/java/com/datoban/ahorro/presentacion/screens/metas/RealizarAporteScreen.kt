package com.datoban.ahorro.presentacion.screens.metas

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.datoban.ahorro.presentacion.viewmodel.AporteViewModel

@Composable
fun RealizarAporteScreen(
    navController: NavController,
    viewModel: AporteViewModel
) {

    var aporte by remember { mutableStateOf("") }
    var descripcion by remember { mutableStateOf("") }
    var metodoPago by remember {
        mutableStateOf("Transferencia bancaria")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        // HEADER
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            IconButton(
                onClick = {
                    navController.popBackStack()
                }
            ) {

                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Volver"
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = "Realizar aporte",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        // CARD META
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(18.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 3.dp
            )
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),

                verticalAlignment = Alignment.CenterVertically
            ) {

                Box(
                    modifier = Modifier
                        .size(70.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(Color(0xFFE9ECEF)),

                    contentAlignment = Alignment.Center
                ) {

                    Text(
                        text = "📺"
                    )
                }

                Spacer(modifier = Modifier.width(14.dp))

                Column(
                    modifier = Modifier.weight(1f)
                ) {

                    Text(
                        text = "Fondo para Televisor 55''",
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    Text(
                        text = "Meta",
                        color = Color.Gray
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = "$3.000.000",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                }

                Text(
                    text = "40% completado",
                    color = Color.Gray,
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }

        Spacer(modifier = Modifier.height(28.dp))

        // MI APORTE
        Text(
            text = "Mi aporte",
            fontWeight = FontWeight.SemiBold
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = aporte,
            onValueChange = {
                aporte = it
            },

            placeholder = {
                Text("$ 300.000")
            },

            modifier = Modifier.fillMaxWidth(),

            shape = RoundedCornerShape(12.dp),

            singleLine = true
        )

        Spacer(modifier = Modifier.height(22.dp))

        // MÉTODO DE PAGO
        Text(
            text = "Método de pago",
            fontWeight = FontWeight.SemiBold
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = metodoPago,
            onValueChange = {},

            modifier = Modifier.fillMaxWidth(),

            shape = RoundedCornerShape(12.dp),

            singleLine = true,

            readOnly = true,

            trailingIcon = {

                Icon(
                    imageVector = Icons.Default.KeyboardArrowDown,
                    contentDescription = "Abrir"
                )
            }
        )

        Spacer(modifier = Modifier.height(22.dp))

        // DESCRIPCIÓN
        Text(
            text = "Descripción (opcional)",
            fontWeight = FontWeight.SemiBold
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = descripcion,
            onValueChange = {
                descripcion = it
            },

            placeholder = {
                Text("Ej. Aporte mensual")
            },

            modifier = Modifier.fillMaxWidth(),

            shape = RoundedCornerShape(12.dp),

            singleLine = true
        )

        Spacer(modifier = Modifier.weight(1f))

        // BOTÓN
        Button(
            onClick = {

                if (aporte.isNotEmpty()) {

                    viewModel.registrarAporte(

                        // EJEMPLO TEMPORAL
                        metaId = 1,

                        // EJEMPLO TEMPORAL
                        miembroId = 1,

                        monto = aporte.toDouble(),

                        metodoPago = metodoPago,

                        descripcion = descripcion
                    )

                    navController.popBackStack()
                }
            },

            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),

            shape = RoundedCornerShape(14.dp),

            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF00A86B)
            )
        ) {

            Text(
                text = "Confirmar aporte",
                color = Color.White
            )
        }
    }
}