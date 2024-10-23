package com.example.ui_layer.screens


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.ui_layer.AppViewModel
import com.example.ui_layer.navigation.SignInScreen


@Composable
fun blockedScreen(
    navController: NavController,
    viewModel: AppViewModel = hiltViewModel(),
    userid: String?
) { // Ensure userid is not null
if (userid == null) {
    // Handle the case where userid is null, maybe navigate to a different screen or show an error
    navController.navigate(SignInScreen) // Navigate to SignInScreen if userid is null
    return
}

val state by viewModel.getSpecificUserState.collectAsState()


when {
    state.Loading -> {
        Box(
            modifier = androidx.compose.ui.Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    }

    state.Error != null -> {
        Box(
            modifier = androidx.compose.ui.Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(text = state.Error.toString())
        }
    }

    state.Data != null -> {

    }
}

Surface {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Admin has not approved your account yet. Please wait.",
            fontSize = 20.sp,
            fontStyle = androidx.compose.ui.text.font.FontStyle.Italic
        )
    }
}
}