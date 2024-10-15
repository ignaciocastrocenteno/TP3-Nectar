package com.nectar.grupo13.proyectofinal.ya22c.tp3.ort.edu.ar.data

import com.nectar.grupo13.proyectofinal.ya22c.tp3.ort.edu.ar.R

sealed class Items(
    val icon: Int,
    val title: String,
    val route: String,
){
    data object SplashScreen: Items(
        0,
        "Nectar Loading Screen",
        "screen_1"
    )
    data object Onboarding: Items(
        0,
        "Presentation of the app - Get Started",
        "screen_2"
    )
    data object SignIn: Items(
        0,
        "Sign In Screen",
        "screen_3"
    )
    data object SignUp: Items(
        0,
        "Sign Up Screen",
        "screen_4"
    )
    data object SelectLocation: Items(
        0,
        "Select your Location - Zone & Area",
        "screen_5"
    )
    data object HomeScreen: Items(
        R.drawable.shop,
        "Shop",
        "screen_6"
    )
    data object Explore: Items(
        R.drawable.explore,
        "Explore",
        "screen_7"
    )
    data object Cart: Items(
        R.drawable.cart,
        "Cart",
        "screen_8"
    )
    data object Favourite: Items(
        R.drawable.favourite,
        "Favourite product list",
        "screen_9"
    )
    data object Account: Items(
        R.drawable.account,
        "Account Settings and other related features",
        "screen_10"
    )
    data object ProductDetails: Items(
        0,
        "Product Details about the selected product",
        "screen_11"
    )
    data object FiltersPopUp: Items(
        0,
        "Filters panel to apply onto the products search",
        "screen_12"
    )
    data object Checkout: Items(
        0,
        "Checkout process - Previewing the delivery, payment, promo code and total cost amount",
        "screen_13"
    )
    data object Categories: Items(
        R.drawable.account,
        "Choosing from the different available categories, then the corresponding products are shown",
        "screen_14"
    )
    data object Search: Items(
        R.drawable.account,
        "Search bar to look for key-terms related to the offered products",
        "screen_15"
    )
    data object OrderedAccepted: Items(
        0,
        "Account",
        "screen_16"
    )
}
