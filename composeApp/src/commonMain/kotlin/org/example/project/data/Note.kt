package org.example.project.data

data class Note(
    val id: Int,
    var title: String,
    var isFavorite: Boolean = false
)