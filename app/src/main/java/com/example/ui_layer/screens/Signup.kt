package com.example.ui_layer.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.medicalstoreuser.R
import com.example.ui_layer.common.MutlicolorText
import com.example.ui_layer.navigation.SignInScreen


@Composable
fun Signup(navController: NavController)
{
    LazyColumn(modifier = Modifier
        .padding(top = 40.dp)
        .fillMaxSize()
        .background(
            color = Color(0xFF29FF52)
        ), horizontalAlignment = Alignment.CenterHorizontally)
    {

         item {
             Image(painter = painterResource(id = R.drawable.logo),
                 contentDescription = null ,
                 modifier= Modifier
                     .padding(top = 10.dp)
                     .size(160.dp)
                     .clip(CircleShape))

             Column(modifier = Modifier
                 .fillMaxSize()
                 .padding(20.dp, 10.dp)
                 .clip(RoundedCornerShape(16.dp))
                 .background(Color.White)
                 , horizontalAlignment = Alignment.CenterHorizontally
             ) {
                 Text(text = "SingUP", fontFamily = FontFamily.SansSerif, fontSize = 24.sp)
                 Spacer(modifier = Modifier.padding(10.dp))
                 OutlinedTextField(
                     value = "",
                     onValueChange = {  },
                     placeholder = { Text("Enter Your Name") }
                 )
                 Spacer(modifier = Modifier.padding(10.dp))
                 OutlinedTextField(
                     value = "",
                     onValueChange = {  },
                     placeholder = { Text("Enter Your Email") }
                 )
                 Spacer(modifier = Modifier.padding(10.dp))
                 OutlinedTextField(
                     value = "",
                     onValueChange = {},
                     placeholder = { Text("Enter Your Password") }
                 )
                 Spacer(modifier = Modifier.padding(10.dp))
                 OutlinedTextField(
                     value = "",
                     onValueChange = {},
                     placeholder = { Text("Enter Your PhoneNumber") }
                 )
                 Spacer(modifier = Modifier.padding(10.dp))
                 OutlinedTextField(
                     value = "",
                     onValueChange = {},
                     placeholder = { Text("Enter Your Address") }
                 )
                 Spacer(modifier = Modifier.padding(10.dp))
                 OutlinedTextField(
                     value = "",
                     onValueChange = {},
                     placeholder = { Text("Enter Your Pin code") }
                 )
                 Spacer(modifier = Modifier.padding(10.dp))
                 OutlinedTextField(
                     value = "",
                     onValueChange = {},
                     placeholder = { Text("Enter Your Name") }
                 )
                 Spacer(modifier = Modifier.padding(10.dp))
                 Button(onClick = {

                 }) {
                     Text("Add User")
                 }
             }
             Spacer(modifier = Modifier.height(40.dp))
             MutlicolorText("Already have an account?"," Sign In",modifier=Modifier.clickable {
                 navController.navigate(SignInScreen)
                 //navController.navigateUp()

             })


         }
        }
    }


