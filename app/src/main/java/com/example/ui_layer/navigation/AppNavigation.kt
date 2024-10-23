package com.example.ui_layer.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.medicalstoreuser.user_praf.UserPreferncesManager
import com.example.ui_layer.AppViewModel
import com.example.ui_layer.screens.MainScreen
import com.example.ui_layer.screens.SignIn
import com.example.ui_layer.screens.Signup
import com.example.ui_layer.screens.blockedScreen


@Composable
fun AppNavigation (
   userPreferncesManager : UserPreferncesManager
)
{
    val navController=rememberNavController()
    val appViewModel: AppViewModel = hiltViewModel()

    val userid by userPreferncesManager.userId.collectAsState(initial = null)

    LaunchedEffect(userid) {
        if(userid !=null)
        {
            navController.navigate(BlockedScreen)
        }
        else{
            navController.navigate(SignInScreen)
        }
    }

    NavHost(navController = navController, startDestination = SignInScreen)

    {

        composable<SignInScreen>{
           SignIn(navController,appViewModel)
        }
        composable<SignupScreen>{
            Signup(navController,appViewModel)
        }
        composable<MainScreen>{
            MainScreen(navController)
        }
        composable<BlockedScreen>{
            blockedScreen(navController,appViewModel,userid)
        }



    }


}