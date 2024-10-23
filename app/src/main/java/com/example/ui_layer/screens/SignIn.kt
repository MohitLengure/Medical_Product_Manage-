package com.example.ui_layer.screens


import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.medicalstoreuser.R
import com.example.ui_layer.AppViewModel
import com.example.ui_layer.common.MutlicolorText
import com.example.ui_layer.navigation.BlockedScreen
import com.example.ui_layer.navigation.SignupScreen


@Composable
fun SignIn(navController: NavController, viewModel: AppViewModel = hiltViewModel()) {

    val state = viewModel.signInUserState.collectAsState()

    when {
        state.value.Loading -> {
            Box(
                modifier = androidx.compose.ui.Modifier.fillMaxSize(),
                contentAlignment = Alignment.BottomCenter
            )
            {
                CircularProgressIndicator()
            }
        }

        state.value.Error != null -> {
            Box(
                modifier = androidx.compose.ui.Modifier.fillMaxSize(),
                contentAlignment = Alignment.BottomCenter
            )
            {
                Text(text = state.value.Error.toString())
            }
        }

        state.value.Data != null -> {
            Box(
                modifier = androidx.compose.ui.Modifier.fillMaxSize(),
                contentAlignment = Alignment.BottomCenter
            )
            {
                Text(text = state.value.Data.toString())
                Log.d("message","${state.value.Data}")
                navController.navigate(BlockedScreen)
            }

        }
    }


    var userEmail by remember { mutableStateOf("") }
    var userPassword by remember {mutableStateOf("")}

    LazyColumn(
        modifier = Modifier
            .padding(top = 10.dp)
            .fillMaxSize()
            .background(
                color = Color(0xFF29FF52)
            ), horizontalAlignment = Alignment.CenterHorizontally
    )
    {

        item {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = null,
                modifier = Modifier
                    .padding(top = 30.dp)
                    .size(160.dp)
                    .clip(CircleShape)
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp, 20.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color.White), horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.padding(10.dp))
                Text(text = "SingUP", fontFamily = FontFamily.SansSerif, fontSize = 24.sp)
                Spacer(modifier = Modifier.padding(10.dp))

                OutlinedTextField(
                    value = userEmail,
                    onValueChange = {userEmail=it},
                    label = { Text("Enter Your Email") }
                )
                Spacer(modifier = Modifier.padding(10.dp))
                OutlinedTextField(
                    value = userPassword,
                    onValueChange = {userPassword=it},
                    label = { Text("Enter Your Password")
                    }
                )
                Spacer(modifier = Modifier.padding(10.dp))
                Button(onClick = {
                    viewModel.LoginUser(
                        email = userEmail,
                        password = userPassword
                    )
                }) {
                    Text("Login User")
                }
            }
            Spacer(modifier = Modifier.height(40.dp))
            MutlicolorText("Don't have an account?"," Sing Up",modifier=Modifier.clickable {
                navController.navigate(SignupScreen)
                {
                    //navController.navigateUp()
                }

            })
        }


    }
}



