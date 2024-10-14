package com.nectar.grupo13.proyectofinal.ya22c.tp3.ort.edu.ar.screens

import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nectar.grupo13.proyectofinal.ya22c.tp3.ort.edu.ar.R
import com.nectar.grupo13.proyectofinal.ya22c.tp3.ort.edu.ar.data.dataExplorer.ExploreItem
import com.nectar.grupo13.proyectofinal.ya22c.tp3.ort.edu.ar.data.dataExplorer.ExploreListItems


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Explore() {
    var searchText by remember { mutableStateOf("") }

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
                    IconButton(onClick = { /* Acción del menú, como redirirgir a la screen
                     del search*/ }) {
                        Icon(Icons.Default.Menu, contentDescription = "Menú")
                    }
                    Spacer(modifier = Modifier.weight(0.7f))
                    Text(
                        text = "Find Products",
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
                TextField(
                    value = searchText,
                    onValueChange = { searchText = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .background(Color(242, 243, 242)),
                    placeholder = { Text("Search Store") },
                    leadingIcon = {
                        Icon(Icons.Default.Search, contentDescription = "Search Icon")
                    },
                    trailingIcon = {
                        IconButton(onClick = { /* Acción del botón de filtrado */ }) {
                            Icon(
                                painter = painterResource(id = R.drawable.filter),
                                contentDescription = "Filter Icon",
                                modifier = Modifier.size(20.dp),
                            )
                        }
                    },
                    shape = RoundedCornerShape(16.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color(242, 243, 242),
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    )
                )
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    contentPadding = PaddingValues(horizontal = 8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(ExploreListItems.size) { index ->
                        ExploreItemCard(ExploreListItems[index])
                    }
                }
            }
        },
    )
}


@Composable
fun ExploreItemCard(product: ExploreItem) {
    val context = LocalContext.current
    val imageResId = remember(product.image) {
        context.resources.getIdentifier(product.image, "drawable", context.packageName)
    }
    val backgroundColor = remember(product.colorR, product.colorG, product.colorB, product.porcentajeColor) {
        Color(product.colorR / 255f, product.colorG / 255f, product.colorB / 255f, product.porcentajeColor)
    }

    Card(
        modifier = Modifier
            .padding(horizontal = 4.dp, vertical = 4.dp)
            .width(150.dp)
            .height(200.dp)
            .border(1.dp, Color.LightGray, shape = RoundedCornerShape(16.dp))
            .clickable {
                // Acción al hacer clic en el recuadro, como por ejemplo
                // navegar a la categoria en particular
            },
        colors = CardDefaults.cardColors(containerColor = backgroundColor),
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = imageResId),
                contentDescription = product.title,
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp)
            )
            Text(
                text = product.title,
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontSize = 16.sp,
                    lineHeight = 22.sp,
                    letterSpacing = 0.1.sp,
                    textAlign = TextAlign.Center
                ),
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}