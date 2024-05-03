package com.kikesf.aprendiendoandroid.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kikesf.aprendiendoandroid.screens.FirstScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = AppScreens.FirstScreen.route
    ) {
        composable(route = AppScreens.FirstScreen.route) {
            FirstScreen()
        }
    }
}