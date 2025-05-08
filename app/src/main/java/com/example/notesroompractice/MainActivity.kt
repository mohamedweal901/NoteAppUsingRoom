package com.example.notesroompractice

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.notesroompractice.database.NoteDatabase
import com.example.notesroompractice.databinding.ActivityMainBinding
import com.example.notesroompractice.repository.NoteRepository
import com.example.notesroompractice.repository.NoteViewModelFactory
import com.example.notesroompractice.viewmodel.NoteViewModel

class MainActivity : AppCompatActivity() {
    lateinit var noteViewModel: NoteViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupViewmodel()

    }
    private fun setupViewmodel(){
        val noteRepository= NoteRepository(NoteDatabase(this))
        val viewModelProviderFactory= NoteViewModelFactory(application,noteRepository)
        noteViewModel= ViewModelProvider(this,viewModelProviderFactory)[NoteViewModel::class.java]


    }
}