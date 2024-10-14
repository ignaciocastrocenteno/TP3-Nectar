package com.nectar.grupo13.proyectofinal.ya22c.tp3.ort.edu.ar

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.ui.platform.LocalContext
import com.nectar.grupo13.proyectofinal.ya22c.tp3.ort.edu.ar.ui.theme.gilroyFontFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SelectLocationScreen() {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                modifier = Modifier.padding(horizontal = 20.dp),
                //App Title here
                title = {},
                navigationIcon = {
                    // Navigation Arrowback Icon
                    Icon(
                        painter = painterResource(id = R.drawable.navigation_arrowback_icon),
                        contentDescription = "Navigation Arrowback Icon",
                        modifier = Modifier.clickable {
                            /* Handle navigation icon click */
                        }
                    )
                },
//                actions = {
//                    // Add action icons or buttons here
//
//                    //Search button
//                    Icon(
//                        imageVector = Icons.Default.Search,
//                        contentDescription = null,
//                        modifier = Modifier
//                            .clickable {
//                                /* Handle search icon click */
//                            }
//                            .scale(1.2f)
//                    )
//                }
            )
        },
        content = { paddingValues ->
            // Content of the screen goes here
            LazyColumn(
                modifier = Modifier
                    .padding(paddingValues = paddingValues),
                content = {
//                    items(20) { index ->
//                        Row(
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .height(60.dp)
//                                .padding(horizontal = 16.dp),
//                            horizontalArrangement = Arrangement.SpaceBetween,
//                            verticalAlignment = Alignment.CenterVertically,
//                            content = {
//                                Text(text = "Item $index")
//                                Icon(
//                                    imageVector = Icons.Default.Settings,
//                                    contentDescription = null
//                                )
//                            }
//                        )
//                    }

                }
            )
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                // Map image Illustration
                Image(
                    painter = painterResource(id = R.drawable.map_illustration),
                    contentDescription = "Map",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp)
                        .padding(top = 100.dp)
                        .padding(bottom = 45.dp)
                        .align(Alignment.CenterHorizontally)
                )

                Text(
                    text = "Select Your Location",
                    style = TextStyle(
                        fontFamily = gilroyFontFamily,
                        fontWeight = FontWeight.W500,
                        fontSize = 26.sp,
                        lineHeight = 29.sp,
                    ),
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(bottom = 12.dp)
                )

                Spacer(modifier = Modifier.height(5.dp))

                // Text elements
                Text(
                    text = "Switch on your location to stay in tune with\n what's happening in your area",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = gilroyFontFamily,
                        color = Color.Gray,
                        textAlign = TextAlign.Center,
                        lineHeight = 20.sp
                    ),
                    modifier = Modifier
                        .padding(start = 30.dp)
                )

                Spacer(modifier = Modifier.height(100.dp))

                // Your Zone dropdown
                val context = LocalContext.current
                val cities = arrayOf("Banshee", "Buenos Aires, Argentina", "Sao Paulo, Brazil", "Montevideo, Uruguay")
                val cityAreas = arrayOf("Caballito", "Almagro", "Flores", "Floresta", "Villa Crespo")
                var citiesExpanded by remember { mutableStateOf(false) }
                var cityAreasExpanded by remember { mutableStateOf(false) }
                var selectedCity by remember { mutableStateOf(cities[0]) }
                var selectedCityAreas by remember { mutableStateOf(cityAreas[0]) }

                // Dropdown 1: City
                Text(
                    text = "Your Zone",
                    style = TextStyle(
                        fontFamily = gilroyFontFamily,
                        fontWeight = FontWeight.W400,
                        color = Color.Gray,
                        fontSize = 16.sp,
                        lineHeight = 29.sp
                    ),
                    modifier = Modifier
                        .padding(start = 4.dp)
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    ExposedDropdownMenuBox(
                        expanded = citiesExpanded,
                        onExpandedChange = {
                            citiesExpanded = !citiesExpanded
                        }
                    ) {
                        TextField(
                            value = selectedCity,
                            onValueChange = {selectedCity = it},
                            readOnly = true,
                            enabled = true,
                            singleLine = true,
                            trailingIcon = {CustomTrailingIcon(citiesExpanded)},
                            modifier = Modifier
                                .width(370.dp)
                                .height(65.dp)
                                .background(Color.Red)
                                .menuAnchor(MenuAnchorType.PrimaryNotEditable, true),
                            colors = TextFieldDefaults.colors(
                                unfocusedContainerColor = Color.White,
                                focusedContainerColor = Color.White,
                                focusedTextColor = Color.Black,
                                unfocusedTextColor = Color.Gray,
                                errorTextColor = Color.Red,
                                cursorColor = Color.Gray,
                                focusedIndicatorColor = Color.LightGray,
                                unfocusedIndicatorColor = Color.LightGray,
                                errorIndicatorColor = Color.Red,
                                focusedTrailingIconColor = Color.Gray,
                                unfocusedTrailingIconColor = Color.Gray,
                                errorTrailingIconColor = Color.Red
                            )
                        )
                        ExposedDropdownMenu(
                            expanded = citiesExpanded,
                            onDismissRequest = { citiesExpanded = false }
                        ) {
                            cities.forEach { item ->
                                DropdownMenuItem(
                                    text = { Text(text = item) },
                                    onClick = {
                                        selectedCity = item
                                        citiesExpanded = false
                                        Toast.makeText(context, item, Toast.LENGTH_SHORT).show()
                                    }
                                )
                            }
                        }
                    }
                }

                // Dropdown 2: City Area
                Text(
                    text = "Your Area",
                    style = TextStyle(
                        fontFamily = gilroyFontFamily,
                        fontWeight = FontWeight.W400,
                        color = Color.Gray,
                        fontSize = 16.sp,
                        lineHeight = 29.sp
                    ),
                    modifier = Modifier
                        .padding(start = 4.dp)
                        .padding(top = 18.dp)
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    ExposedDropdownMenuBox(
                        expanded = cityAreasExpanded,
                        onExpandedChange = {
                            cityAreasExpanded = !cityAreasExpanded
                        }
                    ) {
                        TextField(
                            value = selectedCityAreas,
                            onValueChange = {selectedCityAreas = it},
                            readOnly = true,
                            enabled = true,
                            singleLine = true,
                            trailingIcon = {CustomTrailingIcon(cityAreasExpanded)},
                            modifier = Modifier
                                .width(370.dp)
                                .height(65.dp)
                                .background(Color.Red)
                                .menuAnchor(MenuAnchorType.PrimaryNotEditable, true),
                            colors = TextFieldDefaults.colors(
                                unfocusedContainerColor = Color.White,
                                focusedContainerColor = Color.White,
                                focusedTextColor = Color.Black,
                                unfocusedTextColor = Color.Gray,
                                errorTextColor = Color.Red,
                                cursorColor = Color.Gray,
                                focusedIndicatorColor = Color.LightGray,
                                unfocusedIndicatorColor = Color.LightGray,
                                errorIndicatorColor = Color.Red,
                                focusedTrailingIconColor = Color.Gray,
                                unfocusedTrailingIconColor = Color.Gray,
                                errorTrailingIconColor = Color.Red
                            )
                        )

                        ExposedDropdownMenu(
                            expanded = cityAreasExpanded,
                            onDismissRequest = { cityAreasExpanded = false }
                        ) {
                            cityAreas.forEach { item ->
                                DropdownMenuItem(
                                    text = { Text(text = item) },
                                    onClick = {
                                        selectedCityAreas = item
                                        cityAreasExpanded = false
                                        Toast.makeText(context, item, Toast.LENGTH_SHORT).show()
                                    }
                                )
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(30.dp))

                // Submit button
                Button(
                    onClick = { /* Handle "Get Started" click */ },
                    modifier = Modifier
                        .width(370.dp)
                        .height(65.dp)
                        .padding(start = 7.dp),
                    contentPadding = PaddingValues(8.dp), // Internal padding inside the button
                    shape = RoundedCornerShape(18.dp), // Smaller corner radius for less rounded button
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF53B175), // Set your custom background color (Purple in this case)
                        contentColor = Color(0xFFFFFFFF) // Set the text color (white)
                    )
                ) {
                    Text(
                        text = "Submit",
                        color = Color(0xFFFFFFFF),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.W400,
                        fontFamily = gilroyFontFamily,
                        textAlign = TextAlign.Center,
                    )
                }
            }
        }
    )

}

@Composable
fun CustomTrailingIcon(expanded: Boolean) {
    val icon = if (expanded) {
        painterResource(id = R.drawable.dropdown_menu_trailing_icon_opened)
    } else {
        painterResource(id = R.drawable.dropdown_menu_trailing_icon_closed)
    }
    val contentDescription = if (expanded) {
        "Show dropdown menu"
    } else {
        "Hide dropdown menu"
    }
    Icon(painter = icon, contentDescription = contentDescription)
}