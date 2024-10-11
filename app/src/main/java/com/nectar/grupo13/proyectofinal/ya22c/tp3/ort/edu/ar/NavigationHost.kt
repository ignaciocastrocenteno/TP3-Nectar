package com.nectar.grupo13.proyectofinal.ya22c.tp3.ort.edu.ar

import androidx.compose.runtime.Composable
import androidx.navigation.NavDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.NavHostController
import com.nectar.grupo13.proyectofinal.ya22c.tp3.ort.edu.ar.Items.*
import com.nectar.grupo13.proyectofinal.ya22c.tp3.ort.edu.ar.screens.*

@Composable
fun NavigationHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Pantalla1.ruta) {
        composable(Pantalla1.ruta) {
            Shop()
        }
        composable(Pantalla2.ruta) {
            Explore()
        }
        composable(Pantalla3.ruta) {
            Cart()
        }
        composable(Pantalla4.ruta) {
            Favourite()
        }
        composable(Pantalla5.ruta) {
            Account()
        }
    }
}