package com.nectar.grupo13.proyectofinal.ya22c.tp3.ort.edu.ar

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController

@Composable
fun GlobalNavigation(navController: NavHostController) {
    val items = listOf(
        Items.SplashScreen,
        Items.Onboarding,
        Items.SignIn,
        Items.SignUp,
        Items.SelectLocation,
        Items.HomeScreen,
        Items.Explore,
        Items.Cart,
        Items.Favourite,
        Items.Account,
        Items.ProductDetails,
        Items.FiltersPopUp,
        Items.Checkout,
        Items.Categories,
        Items.Search
    )
    var selectedItem by remember { mutableStateOf<Items>(Items.SplashScreen) }

//    NavigationBar(containerColor = Color(252, 252, 252)) {
//        items.forEach { item ->
//            NavigationBarItem(
//                icon = {
//                    Icon(
//                        painter = painterResource(id = item.icon),
//                        contentDescription = item.title,
//                        tint = if (item == selectedItem) Color(83, 177, 117) else Color(24,23,37)
//                    )
//                },
//                selected = item == selectedItem,
//                onClick = {
//                    selectedItem = item
//                    navController.navigate(item.ruta) {
//                        popUpTo(navController.graph.startDestinationId) {
//                            saveState = true
//                        }
//                        launchSingleTop = true
//                        restoreState = true
//                    }
//                },
//                alwaysShowLabel = false,
//                colors = NavigationBarItemDefaults.colors(
//                    selectedIconColor = Color(83, 177, 117),
//                    unselectedIconColor = Color.Gray,
//                    indicatorColor = Color.Transparent
//                )
//            )
//        }
//    }
}