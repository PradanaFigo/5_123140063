package org.example.project.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import org.example.project.data.Note

class NoteViewModel : ViewModel() {

    var notes = mutableStateListOf(
        Note(1, "Belajar Compose"),
        Note(2, "Kerjakan Tugas Mobile"),
        Note(3, "Meeting Proyek")
    )

    fun getNoteById(id: Int): Note? = notes.find { it.id == id }

    fun addNote(text: String) {
        val newId = (notes.maxOfOrNull { it.id } ?: 0) + 1
        notes.add(Note(newId, text))
    }

    fun updateNote(id: Int, newText: String) {
        getNoteById(id)?.title = newText
    }

    fun toggleFavorite(id: Int) {
        val note = getNoteById(id)
        note?.isFavorite = !(note?.isFavorite ?: false)
    }

    fun getFavorites(): List<Note> = notes.filter { it.isFavorite }
}