package com.nectar.grupo13.proyectofinal.ya22c.tp3.ort.edu.ar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.nectar.grupo13.proyectofinal.ya22c.tp3.ort.edu.ar.ui.theme.CategoriesScreen
import com.nectar.grupo13.proyectofinal.ya22c.tp3.ort.edu.ar.ui.theme.CheckoutModal
import com.nectar.grupo13.proyectofinal.ya22c.tp3.ort.edu.ar.ui.theme.FilterScreen
import com.nectar.grupo13.proyectofinal.ya22c.tp3.ort.edu.ar.ui.theme.NectarTheme
import com.nectar.grupo13.proyectofinal.ya22c.tp3.ort.edu.ar.ui.theme.ProductDetailScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NectarTheme {
                Scaffold( modifier = Modifier.fillMaxSize() ) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                    //ProductDetails()
                    //Filter()
                    //Checkout()
                    Categories()

                }
            }
        }
    }

}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NectarTheme {
        Greeting("Android")
    }
}
/*
@Composable
fun ProductDetails() {
    ProductDetailScreen()
}

@Preview(showBackground = true)
@Composable
fun ProductDetailsPreview() {
    NectarTheme {
        ProductDetails()
    }
}

@Composable
fun Filter() {
    FilterScreen()
}

@Preview(showBackground = true)
@Composable
fun FilterScreenPreview() {
    NectarTheme {
        Filter()
    }
}

@Composable
fun Checkout() {
    CheckoutModal()
}

@Preview(showBackground = true)
@Composable
fun CheckoutScreenPreview() {
    NectarTheme {
        Checkout()
    }
}
*/
@Composable
fun Categories() {
    CategoriesScreen()
}

@Preview(showBackground = true)
@Composable
fun CategoriesScreenPreview() {
    NectarTheme {
        Categories()
    }
}
