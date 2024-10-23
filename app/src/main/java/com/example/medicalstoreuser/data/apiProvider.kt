package com.example.medicalstoreuser.data

import com.example.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object apiProvider {

    fun provideApi()=Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(OkHttpClient.Builder().build())
        .addConverterFactory(
            GsonConverterFactory.create()
        ).build().create(apiServies::class.java)

}