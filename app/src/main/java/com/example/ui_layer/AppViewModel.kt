package com.example.ui_layer

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.medicalstoreuser.State
import com.example.medicalstoreuser.data.responce.getSpecificResponse
import com.example.medicalstoreuser.data.responce.loginresponse
import com.example.medicalstoreuser.data.responce.signUpResponce
import com.example.medicalstoreuser.repo.UserRepo
import com.example.medicalstoreuser.user_praf.UserPreferncesManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow


import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class AppViewModel @Inject constructor(
    private val repo: UserRepo, private val userPreferncesManager: UserPreferncesManager
) : ViewModel() {

    private val _singUpUserState = MutableStateFlow(SignUpUserState())
    val singUpUserState = _singUpUserState.asStateFlow()

    fun signUpUser(
        name: String,
        password: String,
        email: String,
        phone_number: String,
        address: String,
        pinCode: String
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            repo.SignUpUser(
                name = name,
                password = password,
                email = email,
                phone_number = phone_number,
                address = address,
                pinCode = pinCode
            )
                .collect {
                    when (it) {
                        is State.Loading -> {
                            _singUpUserState.value = SignUpUserState(Loading = true)
                        }

                        is State.Success -> {
                            _singUpUserState.value =
                                SignUpUserState(Data = it.data, Loading = false)

                        }

                        is State.Error -> {
                            _singUpUserState.value =
                                SignUpUserState(Error = it.message, Loading = false)
                        }
                    }
                }
        }


    }


    private val _signInUserState = MutableStateFlow(SignInUserState())
    val signInUserState = _signInUserState.asStateFlow()

    fun LoginUser(
        email: String,
        password: String
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            repo.login(
                email, password
            ).collect { state ->
                when (state) {
                    is State.Loading -> {
                        _signInUserState.value = SignInUserState(Loading = true)
                    }

                    is State.Success -> {
                        val  userId = state.data.message()
                        userPreferncesManager.saveUserId(userId)
                        _signInUserState.value = SignInUserState(Data = state.data, Loading = false)
                    }

                    is State.Error -> {
                        _signInUserState.value =
                            SignInUserState(Error = state.message, Loading = false)
                    }
                }
            }
        }
    }




    private val _getSpecificUserState = MutableStateFlow(getspecificUserState())
    val getSpecificUserState = _getSpecificUserState.asStateFlow()
    fun getSpecificUser(userID: String) {
        viewModelScope.launch(Dispatchers.IO) {
            repo.getSpecificUser(
                userID = userID
            ).collect {
                when (it) {
                    is State.Loading -> {
                        _getSpecificUserState.value = getspecificUserState(Loading = true)
                    }

                    is State.Success -> {
                        _getSpecificUserState.value =
                            getspecificUserState(Data = it.data, Loading = false)
                    }

                    is State.Error -> {
                        _getSpecificUserState.value =
                            getspecificUserState(Error = it.message, Loading = false)
                    }
                }
            }
        }
    }

}

data class SignUpUserState(
    val Loading: Boolean = false,
    val Error: String? = null,
    val Data: Response<signUpResponce>? = null
)

data class SignInUserState(
    val Loading: Boolean = false,
    val Error: String? = null,
    val Data: Response<loginresponse>? = null
)

data class getspecificUserState(
    val Loading: Boolean = false,
    val Error: String? = null,
    val Data: Response<getSpecificResponse>? = null
)
