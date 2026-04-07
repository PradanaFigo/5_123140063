#  MyProfile App + Notes Feature

## Identitas

* **Nama:** Pradana Figo Ariasya
* **NIM:** (isi NIM kamu)
* **Prodi:** Teknik Informatika
* **Universitas:** Institut Teknologi Sumatera (ITERA)

---

## Deskripsi Aplikasi

Aplikasi **MyProfile App** merupakan aplikasi berbasis **Kotlin Multiplatform (Compose Multiplatform)** yang menampilkan profil pengguna serta fitur tambahan berupa manajemen catatan (Notes).

Aplikasi ini dikembangkan sebagai tugas praktikum dengan fokus pada:

* Navigasi antar layar (Navigation Compose)
* State management menggunakan ViewModel
* UI modern dengan Material Design 3
* Konsistensi tema antar halaman

---

## Fitur Utama

###  Profile Screen

* Menampilkan informasi profil pengguna
* Statistik (Proyek, IPK, Semester)
* Dark Mode toggle (UI)
* Tampilan modern dengan card & gradient

---

###  Notes Screen

* Menampilkan daftar catatan
* UI berbentuk card (clean & modern)
* Klik item → menuju detail
* Bisa menandai sebagai favorite 

---

### Favorites Screen

* Menampilkan catatan yang difavoritkan
* Tampilan konsisten dengan Notes
* State otomatis update

---

### Add Note

* Floating Action Button (FAB)
* Menambahkan catatan baru
* Data langsung muncul di list

---

### Note Detail

* Menampilkan isi catatan berdasarkan **noteId**
* Navigasi dari list → detail

---

### Edit Note

* Mengedit isi catatan
* Data tersimpan & langsung update
* Menggunakan passing argument (noteId)

---

### Navigation

* Bottom Navigation (3 tab):

    * Notes
    * Favorites
    * Profile
* Back navigation berfungsi dengan baik
* Navigation Compose digunakan

---

## Arsitektur

Aplikasi menggunakan pendekatan sederhana berbasis:

* **MVVM (Model - ViewModel - View)**

### Struktur Folder

```
composeApp/
│
├── data/
│   └── Note.kt
│
├── viewmodel/
│   └── NoteViewModel.kt
│
├── screens/
│   ├── notes/
│   │   ├── NoteListScreen.kt
│   │   ├── NoteDetailScreen.kt
│   │   ├── AddNoteScreen.kt
│   │   └── EditNoteScreen.kt
│   │
│   ├── favorites/
│   │   └── FavoritesScreen.kt
│   │
│   └── profile/
│       └── ProfileScreen.kt
│
├── navigation/
│   ├── AppNavigation.kt
│   └── Screen.kt
│
└── App.kt
```

---

## Teknologi yang Digunakan

* Kotlin Multiplatform
* Jetpack Compose / Compose Multiplatform
* Material 3
* Navigation Compose
* ViewModel
* State Management (mutableStateListOf)

---

##  Alur Navigasi

```
Notes → Detail → Edit → Back → Notes
        ↓
       Favorite

FAB → Add Note → Back → Notes

Bottom Navigation:
Notes ↔ Favorites ↔ Profile
```

---

##  Konsep yang Dipelajari

* Navigation dengan argument (noteId)
* State sharing antar screen (ViewModel)
* Dynamic UI update
* Reusable UI component
* Theming & konsistensi desain

---

## Screenshot (Opsional)

Tambahkan screenshot aplikasi:

* Profile Screen
* Notes Screen
* Detail Screen
* Favorites Screen

---

##  Cara Menjalankan

1. Buka project di Android Studio
2. Jalankan emulator / device Android
3. Klik **Run**
4. Pastikan menjalankan di Android (bukan Desktop)

---

##  Catatan

* Navigation Compose hanya berjalan optimal di Android
* Desktop mode tidak digunakan untuk fitur navigation

---

## Status

✔ Semua fitur sesuai soal telah diimplementasikan
✔ UI konsisten dan modern
✔ Tidak terdapat error

---

## Kesimpulan

Aplikasi ini berhasil mengimplementasikan konsep navigasi, state management, dan UI modern menggunakan Compose. Semua fitur berjalan dengan baik dan sesuai dengan kebutuhan tugas.

---


