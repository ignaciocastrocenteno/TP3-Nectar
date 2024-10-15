package com.nectar.grupo13.proyectofinal.ya22c.tp3.ort.edu.ar.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
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
import com.nectar.grupo13.proyectofinal.ya22c.tp3.ort.edu.ar.data.dataEgg.Egg
import com.nectar.grupo13.proyectofinal.ya22c.tp3.ort.edu.ar.data.dataEgg.EggListItems
import com.nectar.grupo13.proyectofinal.ya22c.tp3.ort.edu.ar.ui.theme.gilroyFontFamily


@Preview
@Composable
fun SearchScreen() {
    var searchText by remember { mutableStateOf("") }

    // Search Wrapper
    Scaffold(
        topBar = {
            NavigationBar(
                modifier = Modifier
                    .padding(top = 20.dp),
                containerColor = Color(252, 252, 252)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = { /* Acción del menú, como redirirgir a la screen
                     del search*/ }) {
                        Icon(Icons.Default.Menu, contentDescription = "Menú")
                    }
                    Spacer(modifier = Modifier.weight(0.7f))
                    // Main Title
                    Text(
                        text = "Search",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                    Spacer(modifier = Modifier.weight(1f))
                }
            }
        },
        content = { innerPadding: PaddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                // Searchbar placeholder text
                TextField(
                    value = searchText,
                    onValueChange = { searchText = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .background(Color(242, 243, 242)),
                    placeholder = { Text("Egg") },
                    leadingIcon = {
                        Icon(Icons.Default.Search, contentDescription = "Search Icon")
                    },
                    shape = RoundedCornerShape(16.dp),
                )
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    item {
                        LazyRow(
                            contentPadding = PaddingValues(horizontal = 1.dp)
                        )
                        {
                            val exclusiveOffers = EggListItems.take(2)
                            items(exclusiveOffers) { product ->
                                ProductCardEgg(product)
                            }
                        }
                    }
                    item {
                        LazyRow(
                            contentPadding = PaddingValues(horizontal = 1.dp)
                        )
                        {
                            val exclusiveOffers = EggListItems.drop(2)
                            items(exclusiveOffers) { product ->
                                ProductCardEgg(product)
                            }
                        }
                    }
                    item {
                        LazyRow(
                            contentPadding = PaddingValues(horizontal = 1.dp)
                        )
                        {
                            val exclusiveOffers = EggListItems.drop(3)
                            items(exclusiveOffers) { product ->
                                ProductCardEgg(product)
                            }
                        }
                    }
                    }
            }
        },
    )
}


@Composable
fun ProductCardEgg(product: Egg) {
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
            // Product Image within each shopping card
            Image(
                painter = painterResource(id = imageResId),
                contentDescription = product.title,
                modifier = Modifier
                    .width(100.dp)
                    .height(75.dp)
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
                        fontSize = 20.sp,
                        fontFamily = gilroyFontFamily,
                        fontWeight = FontWeight.W700
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = product.content,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontSize = 16.sp,
                        fontFamily = gilroyFontFamily,
                        fontWeight = FontWeight.W700,
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
                        fontFamily = gilroyFontFamily,
                        fontWeight = FontWeight.W700,
                        fontSize = 18.sp
                    )
                )
                Button(
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