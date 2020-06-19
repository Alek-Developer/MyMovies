package com.gsixacademy.android.mymovies.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiServiceBuilder {


    val client = OkHttpClient.Builder().build()

    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun<T>buildService(service: Class<T>): T {
        return retrofit.create(service)
    }
}