package com.nectar.grupo13.proyectofinal.ya22c.tp3.ort.edu.ar.screens

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.nectar.grupo13.proyectofinal.ya22c.tp3.ort.edu.ar.ui.theme.gilroyFontFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopBar(text: String, navController: NavController) {
    TopAppBar(
        title = { Text(text = text,
            modifier = Modifier
                .fillMaxWidth(),
            fontSize = 22.sp,
            fontWeight = FontWeight.W700,
            fontFamily = gilroyFontFamily,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.headlineMedium) },
            modifier = Modifier.padding(end = 40.dp),

        navigationIcon = {
            IconButton(onClick = { navController.navigate("shop") }) {
                Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft, contentDescription = "Back")
            }
        }
    )
}