package com.nectar.grupo13.proyectofinal.ya22c.tp3.ort.edu.ar.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// Creating a singleton class to set up Retrofit
object RetrofitInstance {
    private const val BASE_URL = "https://fakestoreapi.com/"

    val api: AuthApi? by lazy {
        // Ensuring the API service is being initialized safely, otherwise throw an exception
        try {
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(AuthApi::class.java)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}
