package com.nectar.grupo13.proyectofinal.ya22c.tp3.ort.edu.ar.data

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

data class LoginRequest(val username: String, val password: String) // Login request body
data class LoginResponse(val token: String) // Response data

interface AuthApi {
    @POST("auth/login")
    fun login(@Body request: LoginRequest): Call<LoginResponse>
}
