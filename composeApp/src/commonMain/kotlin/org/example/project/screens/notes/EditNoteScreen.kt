package org.example.project.screens.notes

import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.example.project.viewmodel.NoteViewModel

@Composable
fun EditNoteScreen(
    id: Int,
    viewModel: NoteViewModel,
    onBack: () -> Unit
) {

    val note = viewModel.getNoteById(id)
    var text by remember { mutableStateOf(note?.title ?: "") }

    Column(Modifier.fillMaxSize().padding(16.dp)) {

        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(16.dp))

        Button(onClick = {
            viewModel.updateNote(id, text)
            onBack()
        }) {
            Text("Update")
        }
    }
}