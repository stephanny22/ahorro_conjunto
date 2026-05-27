package com.datoban.ahorro.presentacion.screens.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.*
import com.datoban.ahorro.presentacion.screens.metas.*

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "misMetas"
    ) {

        composable("misMetas") {
            MisMetasScreen(navController)
        }

        composable("detalleMeta/{id}") { backStack ->

            val id =
                backStack.arguments?.getString("id")?.toInt() ?: 1

            DetalleMetaScreen(
                navController,
                id
            )
        }

        composable("crearMeta") {
            CrearMetaScreen(navController)
        }

        composable("aporte") {
            RealizarAporteScreen(navController)
        }
    }
}