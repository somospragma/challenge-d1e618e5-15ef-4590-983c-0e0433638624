package com.pragma.transferapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.pragma.transferapp.presentation.ui.screens.TransferScreen

sealed class Screen(val route: String) {
    object Transfer : Screen("transfer")
}

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController, startDestination = Screen.Transfer.route) {
        composable(Screen.Transfer.route) {
            TransferScreen(navController)
        }
    }
}