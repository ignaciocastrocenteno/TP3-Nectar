package com.nectar.grupo13.proyectofinal.ya22c.tp3.ort.edu.ar

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.navigation.NavController
import com.nectar.grupo13.proyectofinal.ya22c.tp3.ort.edu.ar.ui.theme.gilroyFontFamily


@Composable
fun SignUpScreen(navController: NavController) {
    var username by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp), // Padding around the screen
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize() // Ensure the Box takes the full screen
                .background(color = Color(0xFFFFFFFF)),
        ) {
            // Top Orange Carrot Image
            Image(
                painter = painterResource(id = R.drawable.orange_carrot),
                contentDescription = "Carrot Logo",
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .padding(top = 60.dp)
            )
        }
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Spacer(modifier = Modifier.height(130.dp))

            // "Sign Up" Title
            Text(
                text = "Sign Up",
                style = TextStyle(
                    fontFamily = gilroyFontFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp
                ),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .offset(x = 8.dp)
            )

            // Subtitle Text
            Text(
                text = "Enter your credentials to continue",
                style = TextStyle(
                    fontFamily = gilroyFontFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp,
                    color = Color.Gray
                ),
                modifier = Modifier
                    .offset(x = 8.dp)
            )

            Spacer(modifier = Modifier.height(10.dp))


            // Username Input Field
            TextField(
                value = username,
                onValueChange = { username = it },
                label = {
                    Text("Username",
                        color = Color.Gray,
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontFamily = gilroyFontFamily,
                            fontWeight = FontWeight.W500
                        )
                    )
                },
                modifier = Modifier.fillMaxWidth(),
                textStyle = TextStyle(
                    fontSize = 18.sp,
                    fontFamily = gilroyFontFamily,
                    fontWeight = FontWeight.W400,
                    color = Color.Black
                ),
                readOnly = false,
                enabled = true,
                singleLine = true,
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Password
                ),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.White,
                    focusedContainerColor = Color.White,
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Gray,
                    errorTextColor = Color.Red,
                    cursorColor = Color.Gray,
                    focusedIndicatorColor = Color.Gray,
                    unfocusedIndicatorColor = Color.Gray,
                    errorIndicatorColor = Color.Red,
                    focusedTrailingIconColor = Color.Gray,
                    unfocusedTrailingIconColor = Color.Gray,
                    errorTrailingIconColor = Color.Red
                )
            )

            Spacer(modifier = Modifier.height(2.dp))

            // Email Input Field
            TextField(
                value = email,
                onValueChange = { email = it },
                label = {
                    Text("Email",
                        color = Color.Gray,
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontFamily = gilroyFontFamily,
                            fontWeight = FontWeight.W500
                        )
                    )
                },
                modifier = Modifier
                    .fillMaxWidth(),
                textStyle = TextStyle(
                    fontSize = 18.sp,
                    fontFamily = gilroyFontFamily,
                    fontWeight = FontWeight.W400,
                    color = Color.Black
                ),
                readOnly = false,
                enabled = true,
                singleLine = true,
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Password
                ),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.White,
                    focusedContainerColor = Color.White,
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Gray,
                    errorTextColor = Color.Red,
                    cursorColor = Color.Gray,
                    focusedIndicatorColor = Color.Gray,
                    unfocusedIndicatorColor = Color.Gray,
                    errorIndicatorColor = Color.Red,
                    focusedTrailingIconColor = Color.Gray,
                    unfocusedTrailingIconColor = Color.Gray,
                    errorTrailingIconColor = Color.Red
                )
            )

            Spacer(modifier = Modifier.height(2.dp))

            // Password Input Field
            TextField(
                value = password,
                onValueChange = { password = it },
                label = {
                    Text("Password",
                        color = Color.Gray,
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontFamily = gilroyFontFamily,
                            fontWeight = FontWeight.W500
                        )
                    )
                },
                modifier = Modifier.fillMaxWidth(),
                textStyle = TextStyle(
                    fontSize = 18.sp,
                    fontFamily = gilroyFontFamily,
                    fontWeight = FontWeight.W400,
                    color = Color.Black
                ),
                readOnly = false,
                enabled = true,
                singleLine = true,
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Password
                ),
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(
                            painter = painterResource(
                                id = if (passwordVisible) R.drawable.ic_visibility else R.drawable.ic_visibility_off
                            ),
                            contentDescription = if (passwordVisible) "Hide password" else "Show password"
                        )
                    }
                },
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.White,
                    focusedContainerColor = Color.White,
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Gray,
                    errorTextColor = Color.Red,
                    cursorColor = Color.Gray,
                    focusedIndicatorColor = Color.Gray,
                    unfocusedIndicatorColor = Color.Gray,
                    errorIndicatorColor = Color.Red,
                    focusedTrailingIconColor = Color.Gray,
                    unfocusedTrailingIconColor = Color.Gray,
                    errorTrailingIconColor = Color.Red
                )
            )

            // TOS & PP text
            Box {
                Text(
                    style = TextStyle(
                        letterSpacing = 0.5.sp,
                        fontFamily = gilroyFontFamily,
//                        fontWeight = FontWeight.W400
                    ),
                    text = AnnotatedString(
                        text = "By continuing you agree to our ",
                        spanStyle = SpanStyle(color = Color.Gray)
                    ) +
                    AnnotatedString(
                         text = "Terms of Service\n",
                         spanStyle = SpanStyle(color = Color(0xFF53B175))
                    ),
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(top = 4.dp)
                        .padding(start = 8.dp)
                )
                Text(
                    style = TextStyle(
                        letterSpacing = 0.5.sp
                    ),
                    text = AnnotatedString(
                        text = "and ",
                        spanStyle = SpanStyle(color = Color.Gray)
                    ) +
                    AnnotatedString(
                        text = "Privacy Policy.",
                        spanStyle = SpanStyle(color = Color(0xFF53B175))
                    ),
                    modifier = Modifier
//                        .align(Alignment.Start)
                        .padding(top = 25.dp)
                        .padding(start = 8.dp)
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Sign Up Button
            Button(
                onClick = { navController.navigate("selectlocation") },
                modifier = Modifier
                    .width(370.dp)
                    .height(65.dp)
                    .offset(y = (-25).dp),
                contentPadding = PaddingValues(8.dp), // Internal padding inside the button
                shape = RoundedCornerShape(18.dp), // Smaller corner radius for less rounded button
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF53B175), // Set your custom background color (Purple in this case)
                    contentColor = Color(0xFFFFFFFF) // Set the text color (white)
                )
            ) {
                Text(
                    text = "Sign Up",
                    color = Color(0xFFFFFFFF),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.W400,
                    fontFamily = gilroyFontFamily,
                    textAlign = TextAlign.Center,
                )
            }

            Spacer(modifier = Modifier.height(1.dp))

            // "Already have an account? Sign Up" Text
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically, // Ensure all texts align vertically
                modifier = Modifier
                    .fillMaxWidth()
                    .offset(y = (-50).dp)
            ) {
                Text(
                    text = "Already have an account?",
                    style = TextStyle(
                        fontFamily = gilroyFontFamily,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.W500,
                        color = Color(0xFF000000)
                    )
                )
                TextButton(onClick = { navController.navigate("signin") }) {
                    Text(
                        text = "Signin",
                        style = TextStyle(
                            fontFamily = gilroyFontFamily,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.W500,
                            color = Color(0xFF53B175)
                        ),
                        modifier = Modifier.offset(x = (-8).dp, y = (-0.2).dp)
                    )
                }
            }
        }
    }
}
