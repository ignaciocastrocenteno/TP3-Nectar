package com.nectar.grupo13.proyectofinal.ya22c.tp3.ort.edu.ar.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.nectar.grupo13.proyectofinal.ya22c.tp3.ort.edu.ar.R
import com.nectar.grupo13.proyectofinal.ya22c.tp3.ort.edu.ar.ui.theme.gilroyFontFamily

@Composable
    fun ProductDetailScreen(navController: NavController) {
        Scaffold(
            topBar = { MyTopBar("Product Details", navController) }
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

                ProductDetailsSection()

                HorizontalDivider()

                NutritionSection()

                HorizontalDivider()

                Spacer(modifier = Modifier.height(8.dp))

                ReviewSection()

                Spacer(modifier = Modifier.height(8.dp))

                Button("Add To Basket")
            }
        }
    }

//@Preview(showBackground = true)
@Composable
fun PreviewProductDetailScreen(navController: NavController) {
    ProductDetailScreen(navController)
}

@Composable
fun ImageSection() {
    Row {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp),
            contentAlignment = Alignment.TopEnd
        ) {

            Image(
                painter = painterResource(id = R.drawable.apple),
                contentDescription = "Red Apple",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .background(
                        color = colorResource(id = R.color.gray),
                        shape = RoundedCornerShape(18.dp)
                    )
            )
            IconButton(
                onClick = { /* lógica para compartir */ },
                modifier = Modifier
                    .padding(10.dp)
                    .size(18.dp)
            ) {
                Image(
                    modifier = Modifier
                    .fillMaxWidth(),
                    painter = painterResource(id = R.drawable.share),
                    contentDescription = "share",

                )
            }
        }
    }
}
@Composable
fun MainSection() {
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
                fontWeight = FontWeight.W700,
                fontFamily = gilroyFontFamily,
                fontSize = 24.sp,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Start
            )
            Text(
                text = "1kg, Price",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                fontFamily = gilroyFontFamily,
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
    Spacer(modifier = Modifier.height(8.dp))

    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = { /* lógica para disminuir */ }) {
            Image(
                painter = painterResource(id = R.drawable.remove),
                contentDescription = "Decrease",
            )
        }
        Text(
            text = "1",
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.W700,
            fontFamily = gilroyFontFamily,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        IconButton(onClick = { /* lógica para aumentar */ }) {
            Image(
                painter = painterResource(id = R.drawable.add),
                contentDescription = "Increase",
            )
        }
        // Precio del producto
        Text(
            text = "$4.99",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.W800,
            fontFamily = gilroyFontFamily,
            color = Color.Black,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.End
        )
    }
}

@Composable
fun ProductDetailsSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Product Details",
            style = TextStyle(
                fontSize = 16.sp,
                fontFamily = gilroyFontFamily,
                fontWeight = FontWeight.W500
            ),
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
            style = TextStyle(
                fontSize = 13.sp,
                fontFamily = gilroyFontFamily,
                fontWeight = FontWeight.W500
            ),
            textAlign = TextAlign.Start,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        )
    }
}

@Composable
fun NutritionSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Nutritions",
            style = TextStyle(
                fontSize = 16.sp,
                fontFamily = gilroyFontFamily,
                fontWeight = FontWeight.W500
            ),
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
fun ReviewSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Review",
            style = TextStyle(
                fontSize = 16.sp,
                fontFamily = gilroyFontFamily,
                fontWeight = FontWeight.W500
            ),
        )
        Spacer(modifier = Modifier.weight(1f))
        Rating(rating = 4f)
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
                tint = colorResource(id = R.color.orange),
                modifier = Modifier
                    .padding(1.dp),
            )
        }
    }
}
