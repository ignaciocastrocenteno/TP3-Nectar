package com.nectar.grupo13.proyectofinal.ya22c.tp3.ort.edu.ar.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.nectar.grupo13.proyectofinal.ya22c.tp3.ort.edu.ar.ui.theme.gilroyFontFamily
import com.nectar.grupo13.proyectofinal.ya22c.tp3.ort.edu.ar.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilterScreen(navController: NavController) {
    // Estados para los checkboxes
    var categoryEggsChecked by remember { mutableStateOf(true) }
    var categoryNoodlesChecked by remember { mutableStateOf(false) }
    var categoryChipsChecked by remember { mutableStateOf(false) }
    var categoryFastFoodChecked by remember { mutableStateOf(false) }

    var brandCollectionChecked by remember { mutableStateOf(false) }
    var brandCocolaChecked by remember { mutableStateOf(true) }
    var brandIfadChecked by remember { mutableStateOf(false) }
    var brandKaziFarmasChecked by remember { mutableStateOf(false) }

    // Filters - PopUp Wrapper
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    // Main Title
                    Text(
                        text = "Filters",
                        fontWeight = FontWeight.W700,
                        fontFamily = gilroyFontFamily,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = androidx.compose.ui.text.style.TextAlign.Center
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.navigate("explore") }) {
                        Icon(imageVector = Icons.Default.Close, contentDescription = "Close")
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
                .background(
                    color = colorResource(id = R.color.gray),
                    shape = RoundedCornerShape(18.dp)
                )

        ) {
            // Categories Section Title
            Text(
                modifier = Modifier
                    .padding(16.dp),
                text = "Categories",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.W700,
                fontFamily = gilroyFontFamily,
            )
            Spacer(modifier = Modifier.height(8.dp))

            // Categories' checkboxes
            CheckBoxItem(
                text = "Eggs",
                isChecked = categoryEggsChecked,
                onCheckedChange = { categoryEggsChecked = it }
            )
            CheckBoxItem(
                text = "Noodles & Pasta",
                isChecked = categoryNoodlesChecked,
                onCheckedChange = { categoryNoodlesChecked = it }
            )
            CheckBoxItem(
                text = "Chips & Crisps",
                isChecked = categoryChipsChecked,
                onCheckedChange = { categoryChipsChecked = it }
            )
            CheckBoxItem(
                text = "Fast Food",
                isChecked = categoryFastFoodChecked,
                onCheckedChange = { categoryFastFoodChecked = it }
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Brand Section Title
            Text(
                text = "Brand",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.W700,
                fontFamily = gilroyFontFamily,
            )
            Spacer(modifier = Modifier.height(8.dp))

            // Brand's checkboxes
            CheckBoxItem(
                text = "Individual Collection",
                isChecked = brandCollectionChecked,
                onCheckedChange = { brandCollectionChecked = it }
            )
            CheckBoxItem(
                text = "Cocola",
                isChecked = brandCocolaChecked,
                onCheckedChange = { brandCocolaChecked = it }
            )
            CheckBoxItem(
                text = "Ifad",
                isChecked = brandIfadChecked,
                onCheckedChange = { brandIfadChecked = it }
            )
            CheckBoxItem(
                text = "Kazi Farmas",
                isChecked = brandKaziFarmasChecked,
                onCheckedChange = { brandKaziFarmasChecked = it }
            )

            Spacer(modifier = Modifier.weight(1f))

            // 'Apply Filter' button
            ApplyFilterButton("Apply Filter", navController)
        }
    }
}

@Composable
fun CheckBoxItem(text: String, isChecked: Boolean, onCheckedChange: (Boolean) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = isChecked,
            onCheckedChange = onCheckedChange,
            colors = CheckboxDefaults.colors(
                checkedColor = colorResource(id = R.color.check),
                uncheckedColor = Color.Gray,
            )
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = text,
                color = if (isChecked) colorResource(id = R.color.check) else Color.Black,
                fontFamily = gilroyFontFamily,
                fontWeight = FontWeight.W400
        )

    }
}

@Composable
fun ApplyFilterButton(text: String, navController: NavController){
    androidx.compose.material3.Button(
        onClick = { navController.navigate("search") },
        modifier = Modifier
            .fillMaxWidth()
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
        Text(text, fontSize = 16.sp)
        Spacer(modifier = Modifier.width(8.dp))
    }
}

//@Preview(showBackground = true)
//@Composable
//fun PreviewFilterScreen(navController: NavController) {
//    FilterScreen(navController)
//}

