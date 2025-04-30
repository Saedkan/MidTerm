package com.example.midterm.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.midterm.presentation.screens.FirstScreen
import com.example.midterm.presentation.screens.SecondScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "first") {
        composable("first") { FirstScreen(navController) }
        composable("second") { SecondScreen() }
    }
}