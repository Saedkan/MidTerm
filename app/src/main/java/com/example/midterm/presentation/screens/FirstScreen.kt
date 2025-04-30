package com.example.midterm.presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun FirstScreen(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(text = "Welcome to HobbyApp", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "This is your first screen")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.navigate("second") }) {
            Text("Go to Second Screen")
        }
    }
}
