package org.example.project.screens.notes

import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.example.project.viewmodel.NoteViewModel

@Composable
fun AddNoteScreen(viewModel: NoteViewModel, onBack: () -> Unit) {

    var text by remember { mutableStateOf("") }

    Column(Modifier.fillMaxSize().padding(16.dp)) {

        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Note") }
        )

        Spacer(Modifier.height(16.dp))

        Button(onClick = {
            if (text.isNotBlank()) {
                viewModel.addNote(text)
                onBack()
            }
        }) {
            Text("Simpan")
        }
    }
}