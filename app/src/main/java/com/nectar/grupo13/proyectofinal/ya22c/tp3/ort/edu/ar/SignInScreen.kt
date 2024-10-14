package com.nectar.grupo13.proyectofinal.ya22c.tp3.ort.edu.ar

import android.content.Context
import android.widget.Toast
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nectar.grupo13.proyectofinal.ya22c.tp3.ort.edu.ar.ui.theme.gilroyFontFamily
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun SignInScreen() {
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }

    // Obtain the context for Toast
    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp) // Padding around the screen
            .background(color = Color.White),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize() // Ensure the Box takes the full screen
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
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Spacer(modifier = Modifier.height(130.dp))

            Text(
                text = "Sign In",
                style = TextStyle(
                    fontFamily = gilroyFontFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp
                ),
                textAlign = TextAlign.Center,
                modifier = Modifier.offset(x = 8.dp)
            )

            Text(
                text = "Enter your email and password",
                style = TextStyle(
                    fontFamily = gilroyFontFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp,
                    color = Color.Gray
                ),
                modifier = Modifier.offset(x = 8.dp)
            )

            Spacer(modifier = Modifier.height(10.dp))

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
                    focusedIndicatorColor = Color.LightGray,
                    unfocusedIndicatorColor = Color.LightGray,
                    errorIndicatorColor = Color.Red,
                    focusedTrailingIconColor = Color.Gray,
                    unfocusedTrailingIconColor = Color.Gray,
                    errorTrailingIconColor = Color.Red
                )
            )

            Spacer(modifier = Modifier.height(10.dp))

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
                textStyle = TextStyle(
                    fontSize = 18.sp,
                    fontFamily = gilroyFontFamily,
                    fontWeight = FontWeight.W400,
                    color = Color.Black
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
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Password),
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

            // "Forgot Password?" TextButton
            TextButton(
                onClick = { /* Handle button click */ }, // Add an onClick handler
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(top = 1.dp)
                    .offset(x = 5.dp, y = (-13).dp)
            ) {
                Text(
                    text = "Forgot Password?",
                    style = TextStyle(
                        fontFamily = gilroyFontFamily,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.W400,
                        color = Color(0xFF000000)
                    )
                )
            }

            Spacer(Modifier.height(3.dp))

            // Log In Button
            Button(
                onClick = { performLogin(email, password, context) },
                modifier = Modifier
                    .width(370.dp)
                    .height(65.dp)
                    .offset(y = (-20).dp),
                shape = RoundedCornerShape(18.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF53B175),
                    contentColor = Color.White
                )
            ) {
                Text("Log In", fontSize = 18.sp, fontWeight = FontWeight.W400)
            }

            // "Don't have an account? Signup" Text
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically, // Ensure all texts align vertically
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 20.dp)
                    .offset(y = (-30).dp)
            ) {
                Text(
                    text = "Don’t have an account?",
                    style = TextStyle(
                        fontFamily = gilroyFontFamily,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.W500,
                        color = Color(0xFF000000)
                    ),
                    modifier = Modifier
                        .offset(x = 7.dp)
                )
                TextButton(onClick = { /* Navigate to Signup */ }) {
                    Text(
                        text = "Signup",
                        style = TextStyle(
                            fontFamily = gilroyFontFamily,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.W400,
                            color = Color(0xFF53B175)
                        )
                    )
                }
            }
        }
    }
}

private fun performLogin(username: String, password: String, context: Context) {
    val loginRequest = LoginRequest(username, password)

    // Ensure RetrofitInstance.api is properly initialized
    val call = RetrofitInstance.api?.login(loginRequest)
        ?: run {
            Toast.makeText(context, "API not initialized", Toast.LENGTH_SHORT).show()
            return
        }

    call.enqueue(object : Callback<LoginResponse> {
        override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
            if (response.isSuccessful && response.body() != null) {
                val token = response.body()?.token
                Toast.makeText(context, "Login Successful! Token: $token", Toast.LENGTH_LONG).show()
            } else {
                val errorMessage = response.errorBody()?.string() ?: "Unknown error"
                Toast.makeText(context, "Login Failed: $errorMessage", Toast.LENGTH_SHORT).show()
            }
        }

        override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
            Toast.makeText(context, "Error: ${t.localizedMessage}", Toast.LENGTH_SHORT).show()
        }
    })
}

