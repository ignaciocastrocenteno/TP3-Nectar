package com.nectar.grupo13.proyectofinal.ya22c.tp3.ort.edu.ar

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nectar.grupo13.proyectofinal.ya22c.tp3.ort.edu.ar.data.dataFavorites.FavouriteItem
import com.nectar.grupo13.proyectofinal.ya22c.tp3.ort.edu.ar.data.dataFavorites.FavouriteListItems

@Preview
@Composable
fun CategoriesScreen(){
    Scaffold(
        topBar = { MyTopBar("Beverages") }
    ) { innerPadding ->

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(innerPadding)
            ) {
                item {
                    LazyRow(
                        contentPadding = PaddingValues(horizontal = 1.dp))
                    {
                        val exclusiveOffers = FavouriteListItems.take(2)
                        items(exclusiveOffers) { product ->
                            ProductBeverages(product)
                        }
                    }
                }

                item {
                    LazyRow(
                        contentPadding = PaddingValues(horizontal = 1.dp))
                    {
                        val exclusiveOffers = FavouriteListItems.drop(2)
                        items(exclusiveOffers) { product ->
                            ProductBeverages(product)
                        }
                    }
                }

                item {
                    LazyRow(
                        contentPadding = PaddingValues(horizontal = 1.dp))
                    {
                        val exclusiveOffers = FavouriteListItems.take(2)
                        items(exclusiveOffers) { product ->
                            ProductBeverages(product)
                        }
                    }
                }

            }
        }
}

@Composable
fun ProductBeverages(product: FavouriteItem) {
    val context = LocalContext.current
    val imageResId = remember(product.image) {
        context.resources.getIdentifier(product.image, "drawable", context.packageName)
    }

    Card(
        modifier = Modifier
            .padding(horizontal = 15.dp, vertical = 8.dp)
            .width(200.dp)
            .height(240.51.dp)
            .border(1.dp, Color(226, 226, 226), shape = RoundedCornerShape(16.dp)),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent),
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = imageResId),
                contentDescription = product.title,
                modifier = Modifier
                    .width(150.dp)
                    .height(120.dp)
                    .padding(top = 30.dp)
                    .clickable {
                        // Acción al hacer clic en la imagen, como por ejemplo
                        // navegar a la pantalla de detalles del producto
                    }
            )
            Column(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = product.title,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = product.content,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontSize = 16.sp,
                        color = Color(124, 124, 124)
                    ),
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "\$${product.price}",
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                )
                androidx.compose.material3.Button(
                    onClick = { /* Acción al agregar al carrito */ },
                    modifier = Modifier
                        .width(75.dp)
                        .height(40.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(83, 177, 117))
                ) {
                    Text(
                        text = "",
                        color = Color.White
                    )
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = ""
                    )
                }
            }
        }
    }
}


