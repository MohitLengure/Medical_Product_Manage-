package com.example.ui_layer

import androidx.compose.foundation.Image
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.medicalstoreuser.R

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Singup(modifier: Modifier=Modifier){
    LazyColumn(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        item {
            Image(painter = painterResource(id = R.drawable.ic_launcher_background), contentDescription = null )
            OutlinedTextField(
                value = "",
                onValueChange = {  },
                placeholder = { Text("Enter Your Name") }
                )
            OutlinedTextField(
                value = "",
                onValueChange = {  },
                placeholder = { Text("Enter Your Email") }
            )
            OutlinedTextField(
                value = "",
                onValueChange = {},
                placeholder = { Text("Enter Your Password") }
            )
            OutlinedTextField(
                value = "",
                onValueChange = {},
                placeholder = { Text("Enter Your PhoneNumber") }
            )
            OutlinedTextField(
                value = "",
                onValueChange = {},
                placeholder = { Text("Enter Your Address") }
            )
            OutlinedTextField(
                value = "",
                onValueChange = {},
                placeholder = { Text("Enter Your Pin code") }
            )
            OutlinedTextField(
                value = "",
                onValueChange = {},
                placeholder = { Text("Enter Your Name") }
            )
        }
    }


}