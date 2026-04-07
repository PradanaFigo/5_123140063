package org.example.project.screens.notes

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.foundation.shape.RoundedCornerShape
import org.example.project.viewmodel.NoteViewModel
import org.example.project.screens.profile.*

@Composable
fun NoteDetailScreen(
    id: Int,
    viewModel: NoteViewModel,
    onBack: () -> Unit,
    onEdit: () -> Unit
) {

    val note = viewModel.getNoteById(id)

    val isDark = false
    val surface = AppColor(isDark, LightColors.Surface, DarkColors.Surface)

    Column(Modifier.fillMaxSize().padding(16.dp)) {

        Text("Detail Note", fontWeight = FontWeight.Bold)

        Spacer(Modifier.height(16.dp))

        Card(
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = surface)
        ) {
            Text(note?.title ?: "-", modifier = Modifier.padding(16.dp))
        }

        Spacer(Modifier.height(20.dp))

        Button(onClick = onEdit, modifier = Modifier.fillMaxWidth()) {
            Text("Edit")
        }

        Spacer(Modifier.height(8.dp))

        OutlinedButton(onClick = onBack, modifier = Modifier.fillMaxWidth()) {
            Text("Back")
        }
    }
}