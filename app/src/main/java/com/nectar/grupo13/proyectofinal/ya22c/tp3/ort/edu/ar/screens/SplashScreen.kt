package com.nectar.grupo13.proyectofinal.ya22c.tp3.ort.edu.ar.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nectar.grupo13.proyectofinal.ya22c.tp3.ort.edu.ar.R

@Composable
fun SplashScreen() {
    Row {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)  // Padding around the screen
                .background(color = Color(0xFF53B175)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Image (Logo)
            Image(
                painter = painterResource(id = R.drawable.nectar_logo), // Use your logo image resource here
                contentDescription = "Nectar Logo",
                modifier = Modifier.size(250.dp),
                contentScale = ContentScale.Fit
            )
            // Subtitle "online groceries"
            Text(
                text = "online groceries",
                style = TextStyle(
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Normal,
                    color = MaterialTheme.colorScheme.onPrimary,
                    textAlign = TextAlign.Center,
                    letterSpacing = 4.6.sp
                ),
                color = MaterialTheme.colorScheme.onPrimary,
                textAlign = TextAlign.Center,
                modifier = Modifier.offset(x = 32.dp, y = (-108).dp)
            )
        }
    }
}