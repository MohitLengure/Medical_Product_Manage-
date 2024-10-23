package com.example.ui_layer.bottomBar

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.medicalstoreuser.data.responce.getSpecificResponse
import com.example.ui_layer.AppViewModel

@Composable
fun Profile(viewModel: AppViewModel = hiltViewModel()) {

    val state by viewModel.getSpecificUserState.collectAsState()
    val context = LocalContext.current

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
            Toast.makeText(context, "Successfully fetched data", Toast.LENGTH_LONG).show()
        }
    }
   /* viewModel.getSpecificUser(userID = userID)
    LazyColumn {
        items(state.Data ?: emptyList()){
            user->
            UserCard(user)
        }
        items(state) { user ->
            // Display each user in a card
            UserCard(user)
        }
    }*/

}


@Composable
fun UserCard(user: getSpecificResponse) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Column(modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()) {
            Text(text = "ID: ${user.id}", style = MaterialTheme.typography.titleSmall)
            Text(text = "User Id: ${user.user_id}", style = MaterialTheme.typography.titleSmall)
            Text(text = "Name: ${user.name}", style = MaterialTheme.typography.titleSmall)
            Text(text = "Phone: ${user.phone_number}", style = MaterialTheme.typography.titleSmall)
            Text(text = "Email: ${user.email}", style = MaterialTheme.typography.titleSmall)
            Text(text = "Level: ${user.level}", style = MaterialTheme.typography.titleSmall)
            Text(text = "Address: ${user.address}", style = MaterialTheme.typography.titleSmall)
            Text(text = "PinCode: ${user.pinCode}", style = MaterialTheme.typography.titleSmall)
            Text(text = "Approve: ${user.isApproved}", style = MaterialTheme.typography.titleSmall)

            Button(onClick = {

            }) {
                Text(text = "Submit")
            }

        }
    }
}

