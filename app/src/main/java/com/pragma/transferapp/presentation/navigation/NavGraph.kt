import com.pragma.transferapp.domain.model.Transfer;
package com.pragma.transferapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.pragma.transferapp.presentation.ui.screens.TransferScreen
import com.pragma.transferapp.presentation.ui.screens.HomeScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) {
            HomeScreen(navController)
        }
        composable(Screen.Transfer.route) {
            TransferScreen(navController)
        }
    }
}