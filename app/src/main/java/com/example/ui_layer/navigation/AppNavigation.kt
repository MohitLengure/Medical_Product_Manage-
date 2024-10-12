package com.example.ui_layer.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ui_layer.screens.SignIn
import com.example.ui_layer.screens.Signup


@Composable
fun AppNavigation(modifier: Modifier =Modifier)
{
    val navController=rememberNavController()
    NavHost(navController = navController, startDestination = SignInScreen)
    {

        composable<SignInScreen>{
           SignIn(navController)
        }
        composable<SignupScreen>{
            Signup(navController)
        }



    }


}