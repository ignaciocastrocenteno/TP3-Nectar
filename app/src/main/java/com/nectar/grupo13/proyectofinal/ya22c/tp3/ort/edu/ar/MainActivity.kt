package com.nectar.grupo13.proyectofinal.ya22c.tp3.ort.edu.ar

import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.nectar.grupo13.proyectofinal.ya22c.tp3.ort.edu.ar.screens.Shop
import kotlinx.coroutines.delay


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
// GLOBAL APP NAVIGATION SYSTEM
            AppNavigation()

//// SPLASH SCREEN
//        SplashScreen()

//// ONBOARDING SCREEN
//            Box(
//                modifier = Modifier.background(color = Color(0xFFFFFFFF)), // Equal the form fields' color
//            ) {
//                Onboarding()
//            }

//// SIGN-IN SCREEN
//            Box(
//                modifier = Modifier.background(color = Color(0xFFFFFFFF)), // Equal the form fields' color
//            ) {
//                SignInScreen()
//            }

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

@Composable
fun MainScreen(){
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigation(navController) }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            NavigationHost(navController)
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

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "splash"
    ) {
        composable("splash") {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = Color(0xFF53B175) // Green Background - Splash Screen
            ) {
                SplashScreen(navController)
            }
        }
        composable("onboarding") {
            OnboardingScreen(navController)
        }
        composable("signin") {
            SignInScreen(navController)
        }
        composable("signup") {
            SignUpScreen(navController)
        }
        composable("selectlocation") {
            SelectLocationScreen(navController)
        }
        composable("shop") {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = Color(0xFFFFFFFF)
            ) {
//                Shop(navController)
                  MainScreen()
            }
        }
    }
}

@Composable
fun SplashScreen(navController: NavHostController) {
    // Using LaunchedEffect to start a coroutine and handle the delay
    LaunchedEffect(Unit) {
        delay(3000)  // 3000ms = 3 seconds
        navController.navigate("onboarding") {
            popUpTo("splash") { inclusive = true }  // Remove Splash from the back stack
        }
    }

    // Splash Screen UI
    SplashScreen()
}

@Composable
fun OnboardingScreen(navController: NavHostController) {
    Onboarding(navController)
}