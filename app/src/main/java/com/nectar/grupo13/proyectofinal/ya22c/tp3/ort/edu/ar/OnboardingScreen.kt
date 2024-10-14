package com.nectar.grupo13.proyectofinal.ya22c.tp3.ort.edu.ar

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nectar.grupo13.proyectofinal.ya22c.tp3.ort.edu.ar.ui.theme.gilroyFontFamily

@Composable
fun Onboarding() {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // Background image (set to fill the whole screen)
        Image(
            painter = painterResource(id = R.drawable.onboarding_background),
            contentDescription = null, // It's a background image, so null is fine
            contentScale = ContentScale.Crop, // Crops the image to fill the entire screen
            modifier = Modifier.fillMaxSize() // Ensures the image takes up the whole screen
        )
        Image(
            painter = painterResource(id = R.drawable.white_carrot),
            contentDescription = null, // It's a background image, so null is fine
//            contentScale = ContentScale.Fit, // Crops the image to fill the entire screen
            modifier = Modifier
                // Ensures the image takes up the whole screen
                .fillMaxWidth()
                .height(56.36.dp)
                .offset(y = (500).dp)
        )
        Text(
            text = " Welcome \n to our store",
//            style = MaterialTheme.typography.headlineMedium,
            style = TextStyle(
                color = Color(0xFFFFFFFF),
                fontFamily = gilroyFontFamily,
                lineHeight = 60.sp,
                fontSize = 48.sp,
                fontWeight = FontWeight.W500,
                textAlign = TextAlign.Center,
                letterSpacing = 1.2.sp
            ),
            modifier = Modifier
                .fillMaxWidth()
                .offset(y = (580).dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Get your groceries in as fast as one hour",
            style = TextStyle(
                color = Color(0xFFFFFFFF),
                fontFamily = gilroyFontFamily,
                fontWeight = FontWeight.Thin,
                fontSize = 17.sp,
                textAlign = TextAlign.Center,
                lineHeight = 15.sp
            ),
            modifier = Modifier
                .fillMaxWidth()
                .offset(y = (700).dp)
        )
        Spacer(modifier = Modifier.height(32.dp))
        Button(
            onClick = { /* Handle "Get Started" click */ },
            modifier = Modifier
                .width(350.dp)
                .height(70.dp)
                .offset(x = 36.dp, y = (765).dp),
            contentPadding = PaddingValues(5.dp), // Internal padding inside the button
            shape = RoundedCornerShape(18.dp), // Smaller corner radius for less rounded button
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF53B175), // Set your custom background color (Purple in this case)
                contentColor = Color(0xFFFFFFFF) // Set the text color (white)
            )
        ) {
            Text(
                text = "Get Started",
                color = Color(0xFFFFFFFF),
                fontSize = 18.sp,
                fontWeight = FontWeight.W400,
            )
        }
    }
}