package com.example.myapplication.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomBar(
    navController: NavController,
    currentLanguage: String
) {
    val items = listOf(
        NavRoutes.Home,
        NavRoutes.Routes,
        NavRoutes.Guide,
        NavRoutes.Settings
    )

    val labelsEn = mapOf(
        NavRoutes.Home to "Home",
        NavRoutes.Routes to "Routes",
        NavRoutes.Guide to "Guide",
        NavRoutes.Settings to "Settings"
    )

    val labelsZh = mapOf(
        NavRoutes.Home to "首页",
        NavRoutes.Routes to "路线",
        NavRoutes.Guide to "攻略",
        NavRoutes.Settings to "设置"
    )

    val labels = if (currentLanguage == "zh") labelsZh else labelsEn

    NavigationBar {
        val navBackStackEntry = navController.currentBackStackEntryAsState().value
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { route ->
            val icon = when (route) {
                NavRoutes.Home -> Icons.Filled.Home
                NavRoutes.Routes -> Icons.Filled.Info
                NavRoutes.Guide -> Icons.Filled.Info
                NavRoutes.Settings -> Icons.Filled.Settings
            }

            NavigationBarItem(
                selected = currentRoute == route.name,
                onClick = { navController.navigate(route.name) },
                icon = { Icon(icon, contentDescription = route.name) },
                label = { Text(labels[route] ?: route.name) }
            )
        }
    }
}
