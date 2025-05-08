package com.example.notesroompractice.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.notesroompractice.model.Note

@Database(entities = [Note::class], version = 1)
abstract class NoteDatabase :RoomDatabase(){
    abstract fun getNoteDao(): NoteDao
    companion object{
        const val DATABASE_NAME="notes_db"
        @Volatile
        private var instance:NoteDatabase?=null
        private val LOCK=Any()
        operator fun invoke(context: Context)= instance ?:
        synchronized(this){
            instance?:
            createDatabase(context).also{
                instance=it
            }
        }

        private fun createDatabase(context: Context)=
            Room.databaseBuilder(
                context.applicationContext,
                NoteDatabase::class.java,
                DATABASE_NAME
            ).build()
    }


}