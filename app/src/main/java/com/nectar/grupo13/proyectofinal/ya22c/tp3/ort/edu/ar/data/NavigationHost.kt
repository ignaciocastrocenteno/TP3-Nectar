package com.nectar.grupo13.proyectofinal.ya22c.tp3.ort.edu.ar.data

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.NavHostController
import com.nectar.grupo13.proyectofinal.ya22c.tp3.ort.edu.ar.SearchScreen
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
        composable("shop") {
            Shop(navController)
        }
        composable(Explore.route) {
            Explore(navController)
        }
        composable("explore") {
            Explore(navController)
        }
        composable(FiltersPopUp.route) {
            FilterScreen(navController)
        }
        composable("filter") {
            FilterScreen(navController)
        }
        composable(Categories.route) {
            CategoriesScreen(navController)
        }
        composable("beverages") {
            CategoriesScreen(navController)
        }
        composable(Search.route) {
            SearchScreen(navController)
        }
        composable("search") {
            SearchScreen(navController)
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
        composable(ProductDetails.route) {
            ProductDetailScreen(navController)
        }
        composable("productdetails") {
            ProductDetailScreen(navController)
        }
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