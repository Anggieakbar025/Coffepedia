package com.anggie.coffepedia.presentations.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.anggie.coffepedia.presentations.screens.WelcomeScreen
import com.anggie.coffepedia.presentations.screens.dashboard.DashboardScreen
import com.anggie.coffepedia.presentations.screens.dashboard.DashboardViewModel
import com.anggie.coffepedia.presentations.screens.detail.DetailScreen
import com.anggie.coffepedia.presentations.screens.detail.DetailViewModel

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String
) {
    val context = LocalContext.current

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(NavigationItem.Welcome.route) {
            WelcomeScreen(navController = navController)
        }
        composable(NavigationItem.Dashboard.route) {
            val viewModel = hiltViewModel<DashboardViewModel>()
            DashboardScreen(navController = navController, viewModel)
        }
        composable(
            NavigationItem.Detail.route,
            arguments = listOf(navArgument("id") {
                type = NavType.StringType
            })
        ) {
            val viewModel = hiltViewModel<DetailViewModel>()
            val id = it.arguments?.getString("id")
            if (id != null) {
                DetailScreen(navController = navController, viewModel, id = id)
            }
        }
    }
}