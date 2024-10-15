package com.nectar.grupo13.proyectofinal.ya22c.tp3.ort.edu.ar.data

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.NavHostController
import com.nectar.grupo13.proyectofinal.ya22c.tp3.ort.edu.ar.data.Items.*
import com.nectar.grupo13.proyectofinal.ya22c.tp3.ort.edu.ar.screens.*

@Composable
fun NavigationHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = HomeScreen.route) {
//        composable(SplashScreen.route) {
//            SplashScreen(navController)
//        }
//        composable(Onboarding.route) {
//            Explore()
//        }
//        composable(SignIn.route) {
//            Cart()
//        }
//        composable(SignUp.route) {
//            Favourite()
//        }
//        composable(SelectLocation.route) {
//            Account()
//        }
        composable(HomeScreen.route) {
            Shop(navController)
        }
        composable(Explore.route) {
            Explore()
        }
        composable(Cart.route) {
            Cart()
        }
        composable(Favourite.route) {
            Favourite()
        }
        composable(Account.route) {
            Account()
        }
//        composable(ProductDetails.route) {
//            ProductDetailScreen()
//        }
//        composable(FiltersPopUp.route) {
//            FilterScreen()
//        }
//        composable(Checkout.route) {
//            CheckoutModal()
//            // [TODO] - Falta hacer el faded de color gris en la Activity 'Cart.kt'
//        }
//        composable(Categories.route) {
//            CategoriesScreen()
//        }
//        composable(Search.route) {
//            // [TODO] - Falta hacer la activity 'Search.kt'
//        }
//        composable(OrderedAccepted.route) {
//            // [TODO] - Falta hacer la activity 'OrderedAccepted.kt'
//        }
    }
}