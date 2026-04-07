package org.example.project.screens.notes

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import org.example.project.viewmodel.NoteViewModel
import org.example.project.screens.profile.*

@Composable
fun NoteListScreen(viewModel: NoteViewModel, onClick: (Int) -> Unit) {

    val isDark = false
    val surface = AppColor(isDark, LightColors.Surface, DarkColors.Surface)
    val textPrimary = AppColor(isDark, LightColors.TextPrimary, DarkColors.TextPrimary)
    val textSecondary = AppColor(isDark, LightColors.TextSecondary, DarkColors.TextSecondary)
    val accent = AppColor(isDark, LightColors.Accent, DarkColors.Accent)

    LazyColumn(modifier = Modifier.fillMaxSize().padding(16.dp)) {

        items(viewModel.notes) { note ->

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 6.dp)
                    .clickable { onClick(note.id) },
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = surface)
            ) {

                Row(
                    modifier = Modifier.padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Column {
                        Text(note.title, fontWeight = FontWeight.Bold, color = textPrimary)
                        Text("Tap untuk detail", color = textSecondary)
                    }

                    IconButton(onClick = {
                        viewModel.toggleFavorite(note.id)
                    }) {
                        Icon(
                            if (note.isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                            contentDescription = null,
                            tint = accent
                        )
                    }
                }
            }
        }
    }
}