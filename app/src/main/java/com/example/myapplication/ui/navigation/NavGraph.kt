package com.example.myapplication.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.myapplication.data.MockRouteData
import com.example.myapplication.ui.guide.GuideScreen
import com.example.myapplication.ui.home.HomeScreen
import com.example.myapplication.ui.routes.RouteDetailScreen
import com.example.myapplication.ui.routes.RoutesScreen
import com.example.myapplication.ui.settings.AboutScreen
import com.example.myapplication.ui.settings.SettingsScreen
import com.example.myapplication.ui.settings.SettingsViewModel

@Composable
fun AppNavGraph(
    navController: NavHostController,
    settingsViewModel: SettingsViewModel
) {
    NavHost(
        navController = navController,
        startDestination = NavRoutes.Home.name
    ) {
        composable(NavRoutes.Home.name) { HomeScreen() }

        composable(NavRoutes.Routes.name) { RoutesScreen(navController) }

        composable(NavRoutes.Guide.name) { GuideScreen() }

        composable(NavRoutes.Settings.name) {
            SettingsScreen(
                settingsViewModel = settingsViewModel,
                navController = navController
            )
        }

        composable("about") { AboutScreen() }

        composable("route/{id}") { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id")?.toIntOrNull()
            val route = MockRouteData.routes.find { it.id == id }
            if (route != null) {
                RouteDetailScreen(route)
            }
        }
    }
}
