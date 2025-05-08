package com.example.notesroompractice.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.notesroompractice.databinding.NoteLayoutBinding
import com.example.notesroompractice.fragments.HomeFragmentDirections
import com.example.notesroompractice.model.Note

class NoteAdapter : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>(){
    class NoteViewHolder(val binding: NoteLayoutBinding):RecyclerView.ViewHolder(binding.root)
    private val differCallback=object : DiffUtil.ItemCallback<Note>(){
        override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
           return oldItem.id==newItem.id&&
                   oldItem.noteTitle==newItem.noteTitle&&
                   oldItem.noteDesc==newItem.noteDesc
        }

        override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem==newItem
        }

    }
    val differ= AsyncListDiffer(this,differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(NoteLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val currentNote=differ.currentList[position]

        holder.binding.noteTitle.text=currentNote.noteTitle
        holder.binding.noteDesc.text=currentNote.noteDesc

        holder.itemView.setOnClickListener{view->
            val action=HomeFragmentDirections.actionHomeFragmentToEditNoteFragment(currentNote)
            view.findNavController().navigate(action)


        }

    }

}