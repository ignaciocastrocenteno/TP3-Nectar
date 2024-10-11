package com.nectar.grupo13.proyectofinal.ya22c.tp3.ort.edu.ar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.nectar.grupo13.proyectofinal.ya22c.tp3.ort.edu.ar.ui.theme.NectarTheme




class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NectarTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen(){
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { NavegacionInferior(navController) }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            NavigationHost(navController)
        }
    }
}

