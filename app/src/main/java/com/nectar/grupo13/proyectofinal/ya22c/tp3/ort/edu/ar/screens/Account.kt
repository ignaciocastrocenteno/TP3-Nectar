package com.nectar.grupo13.proyectofinal.ya22c.tp3.ort.edu.ar.screens


import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nectar.grupo13.proyectofinal.ya22c.tp3.ort.edu.ar.R
import com.nectar.grupo13.proyectofinal.ya22c.tp3.ort.edu.ar.data.dataAccount.AccountData
import com.nectar.grupo13.proyectofinal.ya22c.tp3.ort.edu.ar.data.dataAccount.AccountListItems
import com.nectar.grupo13.proyectofinal.ya22c.tp3.ort.edu.ar.data.dataAccount.ProfileData
import com.nectar.grupo13.proyectofinal.ya22c.tp3.ort.edu.ar.data.dataAccount.ProfileListItems



@Composable
fun Account() {
    var isDarkMode by remember { mutableStateOf(false) }

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
                        text = "Account",
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
                    item {
                        ProfileInfo(profile = ProfileListItems.first())
                    }
                    items(AccountListItems) { item ->
                        AccountProduct(item)
                        Divider(color = Color.LightGray, thickness = 1.dp)
                    }
                    item {
                        DarkModeToggle(isDarkMode = isDarkMode) { isChecked ->
                            isDarkMode = isChecked
                        }
                    }
                }
                LogOut()
            }
        },
    )
}

@Composable
fun AccountProduct(product: AccountData) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = product.iconResId),
            contentDescription = product.title,
            modifier = Modifier.size(24.dp)
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
            Spacer(modifier = Modifier.height(8.dp))
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
        ) {
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
fun LogOut() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { /* Acción de logout */ },
            enabled = false,
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
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.ExitToApp,
                    contentDescription = "Exit",
                    modifier = Modifier.size(24.dp),
                    tint = Color(0xFF53B175) // Set icon color
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text("Log Out", fontSize = 20.sp, color = Color(0xFF53B175))
            }
        }
    }
}

@Composable
fun DarkModeToggle(isDarkMode: Boolean, onToggle: (Boolean) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Dark Mode",
            style = MaterialTheme.typography.bodyLarge.copy(
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Start
            )
        )
        Switch(
            checked = isDarkMode,
            onCheckedChange = onToggle
        )
    }
}

@Composable
fun ProfileInfo(profile: ProfileData) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.photo),
            contentDescription = profile.name,
            modifier = Modifier.size(48.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = profile.name,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Start
                    )
                )
                Spacer(modifier = Modifier.width(8.dp))
                IconButton(onClick = { /* Acción de editar perfil */ }) {
                    Icon(Icons.Default.Edit, contentDescription = "Editar perfil")
                }
            }
            Text(
                text = profile.email,
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontSize = 16.sp,
                    textAlign = TextAlign.Start
                )
            )
        }
    }
}