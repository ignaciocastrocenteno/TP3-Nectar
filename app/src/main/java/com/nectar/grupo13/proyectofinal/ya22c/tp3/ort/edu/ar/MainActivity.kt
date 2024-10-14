package com.nectar.grupo13.proyectofinal.ya22c.tp3.ort.edu.ar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import com.nectar.grupo13.proyectofinal.ya22c.tp3.ort.edu.ar.ui.theme.NectarTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
//// SPLASH SCREEN
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = Color(0xFF53B175) // Green Background - Splash Screen
//                ) {
//                    SplashScreen()
//                }

//// ONBOARDING SCREEN
//            Box(
//                modifier = Modifier.background(color = Color(0xFFFFFFFF)), // Equal the form fields' color
//            ) {
//                Onboarding()
//            }

// SIGN-IN SCREEN
            Box(
                modifier = Modifier.background(color = Color(0xFFFFFFFF)), // Equal the form fields' color
            ) {
                SignInScreen()
            }

//// SIGN-UP SCREEN
//            Box(
//                modifier = Modifier.background(color = Color(0xFFFFFFFF)), // Equal the form fields' color
//            ) {
//                SignUpScreen()
//            }

//// SELECT LOCATION SCREEN
//                SelectLocationScreen()
            }
        }
    }

// Converting PX to DP for easier usage of units
@Composable
fun pixelsToDp(pixelsToConvert: Int): Dp {
    val screenDensity = LocalDensity.current
    val valueConverted = with(screenDensity) { pixelsToConvert.toDp() }

    return valueConverted
}