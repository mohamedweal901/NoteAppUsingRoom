package com.example.notesroompractice.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notesroompractice.model.Note
import com.example.notesroompractice.repository.NoteRepository
import kotlinx.coroutines.launch

class NoteViewModel(app:Application,val noteRepository: NoteRepository): AndroidViewModel(app) {
    fun addNot(note: Note)=
        viewModelScope.launch {
            noteRepository.insertNote(note)
        }

    fun deleteNote(note: Note)=
        viewModelScope.launch {
            noteRepository.deleteNote(note)
        }


    fun updateNote(note: Note)=
        viewModelScope.launch {
            noteRepository.updateNote(note)
        }

    fun getAllNote()=noteRepository.getAllNote()
    fun serachNote(query:String?)=noteRepository.searchNote(query)

}