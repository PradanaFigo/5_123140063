package org.example.project.navigation

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*

@Composable
fun BottomBar(navController: NavController) {

    val items = listOf(
        Screen.Notes,
        Screen.Favorites,
        Screen.Profile
    )

    NavigationBar {

        val currentRoute =
            navController.currentBackStackEntryAsState().value?.destination?.route

        items.forEach { screen ->
            NavigationBarItem(
                selected = currentRoute == screen.route,
                onClick = {
                    navController.navigate(screen.route) {
                        // 🔥 FIX DI SINI
                        popUpTo(Screen.Notes.route)
                        launchSingleTop = true
                    }
                },
                icon = {
                    Icon(
                        when (screen) {
                            Screen.Notes -> Icons.Default.Home
                            Screen.Favorites -> Icons.Default.Favorite
                            Screen.Profile -> Icons.Default.Person
                            else -> Icons.Default.Home
                        },
                        contentDescription = null
                    )
                },
                label = { Text(screen.route) }
            )
        }
    }
}