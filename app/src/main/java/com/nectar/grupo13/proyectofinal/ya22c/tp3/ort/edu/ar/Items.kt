package com.nectar.grupo13.proyectofinal.ya22c.tp3.ort.edu.ar

sealed class Items(
    val icon: Int,
    val title: String,
    val ruta: String,
){
    object Pantalla1: Items(
        R.drawable.shop,
        "Shop",
        "pantalla1"
    )
    object Pantalla2: Items(
        R.drawable.explore,
        "Explore",
        "pantalla2"
    )
    object Pantalla3: Items(
        R.drawable.cart,
        "Cart",
        "pantalla3"
    )

    object Pantalla4: Items(
        R.drawable.favourite,
        "Favourite",
        "pantalla4"
    )

    object Pantalla5: Items(
        R.drawable.account,
        "Account",
        "pantalla5"
    )
}
