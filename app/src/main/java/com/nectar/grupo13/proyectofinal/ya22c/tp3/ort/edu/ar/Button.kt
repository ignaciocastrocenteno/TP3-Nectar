package com.nectar.grupo13.proyectofinal.ya22c.tp3.ort.edu.ar

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Button(text: String){
    androidx.compose.material3.Button(
        onClick = { /* Acción de checkout */ },
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .width(364.dp)
            .border(
                width = 10.dp,
                color = Color.Transparent,
                shape = CircleShape
            ),

        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF53B175)),
        shape = RoundedCornerShape(12.dp)
    ) {
        Text(text, fontSize = 16.sp)
        androidx.compose.foundation.layout.Spacer(modifier = Modifier.width(8.dp))
    }
}