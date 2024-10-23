package com.example.medicalstoreuser.di

import android.content.Context
import com.example.BASE_URL
import com.example.medicalstoreuser.data.apiServies
import com.example.medicalstoreuser.repo.UserRepo
import com.example.medicalstoreuser.user_praf.UserPreferncesManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

   /* @Singleton
    @Provides
    fun provideRepo()= repo()*/

    @Provides
    @Singleton
    fun provideApiService(): apiServies {
        return Retrofit.Builder()
            .baseUrl(BASE_URL) // Use your API base URL
            .addConverterFactory(GsonConverterFactory.create()) // or another converter
            .build()
            .create(apiServies::class.java)
    }


    @Singleton
    @Provides
    fun provideContext(@ApplicationContext context: Context) = context




    @Singleton
    @Provides
    fun providePrefmenger(
        @ApplicationContext context: Context
    ) = UserPreferncesManager(context = context)



}