package org.example.project.screens.favorites

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.shape.RoundedCornerShape
import org.example.project.viewmodel.NoteViewModel
import org.example.project.screens.profile.*

@Composable
fun FavoritesScreen(viewModel: NoteViewModel) {

    val favorites = viewModel.getFavorites()
    val isDark = false
    val surface = AppColor(isDark, LightColors.Surface, DarkColors.Surface)

    if (favorites.isEmpty()) {
        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text("Belum ada favorite")
        }
    } else {
        LazyColumn(Modifier.fillMaxSize().padding(16.dp)) {
            items(favorites) { note ->
                Card(
                    modifier = Modifier.fillMaxWidth().padding(vertical = 6.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = surface)
                ) {
                    Text(note.title, modifier = Modifier.padding(16.dp))
                }
            }
        }
    }
}