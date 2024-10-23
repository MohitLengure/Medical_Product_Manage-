package com.example.medicalstoreuser.repo


import com.example.medicalstoreuser.State
import com.example.medicalstoreuser.data.apiProvider
import com.example.medicalstoreuser.data.apiServies
import com.example.medicalstoreuser.data.responce.getSpecificResponse
import com.example.medicalstoreuser.data.responce.loginresponse
import com.example.medicalstoreuser.data.responce.signUpResponce
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import javax.inject.Inject


class UserRepo @Inject constructor(
    private val apiService: apiServies
) {

    suspend fun SignUpUser(
        name: String,
        password: String,
        email: String,
        phone_number: String,
        address: String,
        pinCode: String
    ): Flow<State<Response<signUpResponce>>> = flow {
        emit(State.Loading)
        try {
            val response = apiProvider.provideApi().SignUpUser(
                name = name,
                password = password,
                email = email,
                phone_number = phone_number,
                address = address,
                pinCode = pinCode,
            )
            emit(State.Success(response))
        } catch (e: Exception) {
            emit(State.Error(e.message.toString()))
        }
    }


    suspend fun login(
        email: String,
        password: String
    ): Flow<State<Response<loginresponse>>> = flow {
        emit(State.Loading)
        try {
            val response = apiProvider.provideApi().login(
                email = email,
                password = password,
            )
            emit(State.Success(response))
        } catch (e: Exception) {
            emit(State.Error(e.message.toString()))

        }
    }

    suspend fun getSpecificUser(
        userID: String
    ):Flow<State<Response<getSpecificResponse>>> = flow {
        emit(State.Loading)
        try{
            val response = apiProvider.provideApi().getSpecificUsers(
                userID = userID
            )
            emit(State.Success(response))
        }catch (e:Exception){
            emit(State.Error(e.message.toString()))
        }
    }



}
