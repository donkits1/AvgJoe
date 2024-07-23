package com.example.avgjoe.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.avgjoe.BikeRack.BikeNav.BikeScreen

@Composable
fun MyNavHost(navController: NavHostController = rememberNavController(), starDest: String) {
    NavHost(navController = navController, startDestination = starDest) {
        composable(route = "LoginScreen") {
            LoginScreen(navController = navController)
        }
        composable(route = "AdminScreen") {
            AdminScreen(navController = navController)
        }
        composable(route = "CustomerScreen") {
            CustomerScreen(navController = navController)
        }
        composable(route = "BikeScreen") {
            BikeScreen(navController = navController)
        }
    }
}



