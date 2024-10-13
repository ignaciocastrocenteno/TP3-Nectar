package com.nectar.grupo13.proyectofinal.ya22c.tp3.ort.edu.ar
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController


@Composable
fun NavegacionInferior(navController: NavHostController) {
    val items = listOf(
        Items.Pantalla1,
        Items.Pantalla2,
        Items.Pantalla3,
        Items.Pantalla4,
        Items.Pantalla5
    )
    var selectedItem by remember { mutableStateOf<Items>(Items.Pantalla1) }

    NavigationBar(containerColor = Color(252, 252, 252)) {
        items.forEach { item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = item.title,
                        tint = if (item == selectedItem) Color(83, 177, 117) else Color(24,23,37)
                    )
                },
                selected = item == selectedItem,
                onClick = {
                    selectedItem = item
                    navController.navigate(item.ruta) {
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                alwaysShowLabel = false,
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color(83, 177, 117),
                    unselectedIconColor = Color.Gray,
                    indicatorColor = Color.Transparent
                )
            )
        }
    }
}
