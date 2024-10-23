package com.example.medicalstoreuser.data

import com.example.medicalstoreuser.data.responce.getSpecificResponse
import com.example.medicalstoreuser.data.responce.loginresponse
import com.example.medicalstoreuser.data.responce.signUpResponce
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface apiServies {

    @FormUrlEncoded
    @POST("signUp")
    suspend fun SignUpUser(
        @Field("name") name: String,
        @Field("password") password: String,
        @Field("email") email: String,
        @Field("phone_number") phone_number: String,
        @Field("address") address: String,
        @Field("pinCode") pinCode: String
    ):Response<signUpResponce>


    @FormUrlEncoded
    @POST("getSpecificUser")
    suspend fun getSpecificUsers(
        @Field("userID") userID: String
    ): Response<getSpecificResponse>


    @FormUrlEncoded
    @POST("login")
    suspend fun login(
        @Field("email") email: String,
        @Field("password") password: String,
    ):Response<loginresponse>



}