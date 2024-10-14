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
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nectar.grupo13.proyectofinal.ya22c.tp3.ort.edu.ar.R
import com.nectar.grupo13.proyectofinal.ya22c.tp3.ort.edu.ar.data.dataShop.Fruit
import com.nectar.grupo13.proyectofinal.ya22c.tp3.ort.edu.ar.data.dataShop.FruitListItems
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.style.TextOverflow


@Composable
fun Shop() {
    Scaffold(
        topBar = {
            NavigationBar(
                containerColor = Color(252, 252, 252)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = { /* Acción del menú */ }) {
                        Icon(Icons.Default.Menu, contentDescription = "Menú")
                    }
                    Spacer(modifier = Modifier.weight(0.7f))
                    Text(
                        text = "Shop",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                    Spacer(modifier = Modifier.weight(1f))
                }
            }
        },
        content = { innerPadding: PaddingValues ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                item {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Dhaka, Banassre",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
                item {
                    FreshVegetableBanner()
                }
                item {
                    Spacer(modifier = Modifier.height(16.dp))
                }
                item {
                    Spacer(modifier = Modifier.height(8.dp))
                }
                item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Exclusive Offer",
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .padding(start = 8.dp)
                        )
                        Text(
                            text = "See all",
                            color = Color(83, 177, 117),
                            modifier = Modifier
                                .padding(end = 8.dp)
                        )
                    }
                }
                item {
                    LazyRow(contentPadding = PaddingValues(horizontal = 8.dp)) {
                        val exclusiveOffers = FruitListItems.take(2)
                        items(exclusiveOffers) { product ->
                            ProductCard(product)
                        }
                    }
                }
                item {
                    Spacer(modifier = Modifier.height(8.dp))
                }
                item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Best Selling",
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .padding(start = 8.dp)
                        )
                        Text(
                            text = "See all",
                            color = Color(83, 177, 117),
                            modifier = Modifier
                                .padding(end = 8.dp)
                        )
                    }
                }
                item {
                    LazyRow(contentPadding = PaddingValues(horizontal = 8.dp)) {
                        val bestSelling = FruitListItems.drop(2)
                        items(bestSelling) { product ->
                            ProductCard(product)
                        }
                    }
                }
            }
        },
    )
}


@Composable
fun FreshVegetableBanner() {
    Image(
        painter = painterResource(id = R.drawable.banner),
        contentDescription = "Fresh Vegetables banner",
        contentScale = ContentScale.Crop,
        modifier = Modifier.height(130.dp)
    )
}

@Composable
fun ProductCard(product: Fruit) {
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