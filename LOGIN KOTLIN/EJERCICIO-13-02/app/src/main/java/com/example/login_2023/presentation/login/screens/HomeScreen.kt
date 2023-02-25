package com.example.aplication_login.presentation.login.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.login_2023.presentation.login.navigation.Destinations

@Composable
fun HomeScreen(navController: NavController, user: String) {
    Column(
        Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "$user")
        Spacer(modifier = Modifier.size(10.dp))
        Button(
            onClick = {navController.navigate(Destinations.RegistrationScreen.route)},
            modifier = Modifier
                .width(200.dp)
                .height(50.dp)
        ) {
            Text(text = "Salir")
        }
    }
}