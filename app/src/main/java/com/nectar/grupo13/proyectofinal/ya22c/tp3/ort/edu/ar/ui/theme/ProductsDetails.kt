package com.nectar.grupo13.proyectofinal.ya22c.tp3.ort.edu.ar.ui.theme
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight


import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nectar.grupo13.proyectofinal.ya22c.tp3.ort.edu.ar.R

    @Composable
    fun ProductDetailScreen() {
        Scaffold(
            topBar = { MyTopBar() }
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(16.dp)
            ) {
                ImageSection()

                Spacer(modifier = Modifier.height(8.dp))

                MainSection()

                HorizontalDivider()

                Spacer(modifier = Modifier.height(8.dp))

                ProductDetailsSection()

                Spacer(modifier = Modifier.height(8.dp))

                HorizontalDivider()

                Spacer(modifier = Modifier.height(8.dp))

                NutritionsSection()

                Spacer(modifier = Modifier.height(8.dp))

                HorizontalDivider()

                Spacer(modifier = Modifier.height(8.dp))

                ReviewSection()

                Button()
               
            }
        }
    }

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopBar() {
    TopAppBar(
        title = { Text(text = "Product Detail",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.headlineMedium) },

        navigationIcon = {
            IconButton(onClick = { /* Acción al presionar el botón de retroceso */ }) {
                Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft, contentDescription = "Back")
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewProductDetailScreen() {
    ProductDetailScreen()
}

@Composable
fun NutritionsSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Nutritions",
            style = MaterialTheme.typography.headlineSmall

        )
        Spacer(modifier = Modifier.weight(1f))
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant,
            ),
            modifier = Modifier
                .size(width = 50.dp, height = 30.dp)
        ) {
            Text(
                text = "100gr",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(2.dp),
                textAlign = TextAlign.Center

            )
        }
        Icon(
            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
            contentDescription = "Ver más"
        )
    }
}

@Composable
fun  ProductDetailsSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Product Details",
            style = MaterialTheme.typography.headlineSmall,

            )
        Spacer(modifier = Modifier.weight(1f))
        Icon(
            imageVector = Icons.Default.KeyboardArrowDown,
            contentDescription = "Ver más"
        )
    }
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Apples are nutritious. Apples may be good for weight loss. Apples may be good for your heart. As part of a healthful and varied diet.",
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Start,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        )
    }
}
@Composable
fun  ImageSection() {
    Row {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp),
            contentAlignment = Alignment.TopEnd
        ) {
            // Imagen del producto con sombra
            Image(
                painter = painterResource(id = R.drawable.apple),  // Reemplaza con tu imagen
                contentDescription = "Red Apple",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .background(
                        color = Color.LightGray,
                        shape = RoundedCornerShape(18.dp)
                    )// Aplicar sombra
            )

            // Icono de compartir en la esquina superior derecha
            IconButton(
                onClick = { /* lógica para compartir */ },
                modifier = Modifier
                    .padding(10.dp)
                    .size(18.dp) // Tamaño del icono

            ) {
                Icon(
                    imageVector = Icons.Default.Share,
                    contentDescription = "Share",
                    tint = Color.Black
                )
            }
        }
    }
}
@Composable
fun  MainSection() {

    Row (
        modifier = Modifier
    )
    {
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = "Naturel Red Apple",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Start
            )
            Text(
                text = "1kg, Price",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

        }
        IconButton(
            onClick = { /* Lógica para marcar como favorito */ }
        ) {
            Icon(
                imageVector = Icons.Default.FavoriteBorder,
                contentDescription = "Add to Favorites",
                tint = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
    Spacer()

    // Botones para aumentar o disminuir cantidad
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = { /* lógica para disminuir */ }) {
            Icon(imageVector = Icons.Default.KeyboardArrowDown, contentDescription = "Decrease")
        }
        Text(
            text = "1",
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        IconButton(onClick = { /* lógica para aumentar */ }) {
            Icon(imageVector = Icons.Default.Add, contentDescription = "Increase")
        }
        // Precio del producto
        Text(
            text = "$4.99",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.End
        )
    }
}

@Composable
fun Spacer(){
    Spacer(modifier = Modifier.height(8.dp))
}

@Composable
fun Button(){
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
        Text("Add To Basket", fontSize = 16.sp)
        Spacer(modifier = Modifier.width(8.dp))
    }
}

@Composable
fun ReviewSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Review",
            style = MaterialTheme.typography.headlineSmall
        )
        Spacer(modifier = Modifier.weight(1f))
        Rating(rating = 4f) // Ajusta la calificación según sea necesario
        Icon(
            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
            contentDescription = "Ver más"
        )
    }
}

@Composable
fun Rating(rating: Float) {
    Row {
        repeat(5) { index ->
            Icon(
                imageVector = if (index < rating) Icons.Filled.Star else Icons.Outlined.Star,
                contentDescription = "Estrella",
                tint = Color.Yellow,
                modifier = Modifier
                    .padding(1.dp),
            )
        }
    }
}
