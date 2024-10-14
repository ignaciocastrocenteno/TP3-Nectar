package com.nectar.grupo13.proyectofinal.ya22c.tp3.ort.edu.ar.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
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
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.nectar.grupo13.proyectofinal.ya22c.tp3.ort.edu.ar.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilterScreen() {
    // Estados para los checkboxes
    var categoryEggsChecked by remember { mutableStateOf(true) }
    var categoryNoodlesChecked by remember { mutableStateOf(false) }
    var categoryChipsChecked by remember { mutableStateOf(false) }
    var categoryFastFoodChecked by remember { mutableStateOf(false) }

    var brandCollectionChecked by remember { mutableStateOf(false) }
    var brandCocolaChecked by remember { mutableStateOf(true) }
    var brandIfadChecked by remember { mutableStateOf(false) }
    var brandKaziFarmasChecked by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Filters",
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = androidx.compose.ui.text.style.TextAlign.Center
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { /* Acción para cerrar */ }) {
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
            // Categorías
            Text(
                modifier = Modifier
                    .padding(16.dp),
                text = "Categories",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold

            )
            Spacer(modifier = Modifier.height(8.dp))

            // Checkboxes de categorías
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

            // Marcas
            Text(
                text = "Brand",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))

            // Checkboxes de marcas
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
            // Botón de aplicar filtro
            Button("Apply Filter")

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
                color = if (isChecked) colorResource(id = R.color.check) else Color.Black)

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewFilterScreen() {
    FilterScreen()
}

