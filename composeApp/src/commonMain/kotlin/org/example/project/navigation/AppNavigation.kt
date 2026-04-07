package org.example.project.navigation

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add

import androidx.navigation.compose.*
import androidx.navigation.NavType
import androidx.navigation.navArgument

import org.example.project.screens.notes.*
import org.example.project.screens.favorites.FavoritesScreen
import org.example.project.screens.profile.ProfileScreen
import org.example.project.viewmodel.NoteViewModel
import org.example.project.screens.notes.AddNoteScreen

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    val noteViewModel = remember { NoteViewModel() }

    Scaffold(
        bottomBar = { BottomBar(navController) },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate(Screen.AddNote.route)
                }
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        }
    ) { padding ->

        NavHost(
            navController = navController,
            startDestination = Screen.Notes.route,
            modifier = Modifier.padding(padding)
        ) {

            // ================= NOTES =================
            composable(Screen.Notes.route) {
                NoteListScreen(
                    viewModel = noteViewModel,
                    onClick = { id ->
                        navController.navigate(
                            Screen.NoteDetail.createRoute(id)
                        )
                    }
                )
            }

            // ================= DETAIL =================
            composable(
                route = Screen.NoteDetail.route,
                arguments = listOf(
                    navArgument("noteId") { type = NavType.IntType }
                )
            ) { backStackEntry ->

                val id = backStackEntry.arguments?.getInt("noteId") ?: 0

                NoteDetailScreen(
                    id = id,
                    viewModel = noteViewModel,
                    onBack = { navController.popBackStack() },
                    onEdit = {
                        navController.navigate(
                            Screen.EditNote.createRoute(id)
                        )
                    }
                )
            }

            // ================= ADD NOTE =================
            composable(Screen.AddNote.route) {
                AddNoteScreen(
                    viewModel = noteViewModel,
                    onBack = { navController.popBackStack() }
                )
            }

            // ================= EDIT NOTE =================
            composable(
                route = Screen.EditNote.route,
                arguments = listOf(
                    navArgument("noteId") { type = NavType.IntType }
                )
            ) { backStackEntry ->

                val id = backStackEntry.arguments?.getInt("noteId") ?: 0

                EditNoteScreen(
                    id = id,
                    viewModel = noteViewModel,
                    onBack = { navController.popBackStack() }
                )
            }

            // ================= FAVORITES =================
            composable(Screen.Favorites.route) {
                FavoritesScreen(viewModel = noteViewModel)
            }

            // ================= PROFILE =================
            composable(Screen.Profile.route) {
                ProfileScreen()
            }
        }
    }
}