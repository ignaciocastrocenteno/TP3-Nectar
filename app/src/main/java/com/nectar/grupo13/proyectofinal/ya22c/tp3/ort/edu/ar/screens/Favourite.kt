package com.nectar.grupo13.proyectofinal.ya22c.tp3.ort.edu.ar.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nectar.grupo13.proyectofinal.ya22c.tp3.ort.edu.ar.data.dataFavorites.FavouriteItem
import com.nectar.grupo13.proyectofinal.ya22c.tp3.ort.edu.ar.data.dataFavorites.FavouriteListItems

@Composable
fun Favourite() {
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
                        text = "Favorites",
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
                LazyColumn(
                    contentPadding = PaddingValues(horizontal = 8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.weight(1f)
                ) {
                    items(FavouriteListItems) { item ->
                        FavouriteProduct(item)
                        Divider(color = Color.LightGray, thickness = 1.dp)
                    }
                }
                AddAllToCart()
            }
        },
    )
}
@Composable
fun FavouriteProduct(product: FavouriteItem) {
    val context = LocalContext.current
    val imageResId = remember(product.image) {
        context.resources.getIdentifier(product.image, "drawable", context.packageName)
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = imageResId),
            contentDescription = product.title,
            modifier = Modifier.size(100.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))

        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = product.title,
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Start
                )
            )
            Text(
                text = product.content,
                style = MaterialTheme.typography.bodySmall.copy(
                    fontSize = 14.sp,
                    color = Color.Gray,
                    textAlign = TextAlign.Start
                )
            )
            Spacer(modifier = Modifier.height(8.dp))
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
        ) {
            Text(
                text = "$${product.price}",
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.End
                ),
                modifier = Modifier.align(Alignment.CenterVertically)
            )
            Icon(
                imageVector = Icons.Default.KeyboardArrowRight,
                contentDescription = "Next",
                modifier = Modifier
                    .size(24.dp)
                    .clickable { /* Acción al hacer clic en el icono */ }
            )
        }
    }
}



@Composable
fun AddAllToCart() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { /* Acción de checkout */ },
            modifier = Modifier
                .height(70.dp)
                .width(364.dp)
                .border(
                    width = 10.dp,
                    color = Color.Transparent,
                    shape = CircleShape
                ),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF53B175)),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text("Add All To Cart", fontSize = 20.sp)
            Spacer(modifier = Modifier.width(8.dp))
        }
    }
}