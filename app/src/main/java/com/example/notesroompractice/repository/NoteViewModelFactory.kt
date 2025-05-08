package com.example.notesroompractice.repository

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.notesroompractice.viewmodel.NoteViewModel

class NoteViewModelFactory(val app:Application,private val repository: NoteRepository):ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NoteViewModel(app,repository) as T
    }

}