package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class NotesRvAdapter(val context : Context, val listener:INotesRVAdapter): RecyclerView.Adapter<NotesRvAdapter.NoteViewHolder>() {
    val allNotes =ArrayList<Note>()
    inner class NoteViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val textView=itemView.findViewById<TextView>(R.id.text)
       // val textView1=itemView.findViewById<TextView>(R.id.text1)

        val deleteButton=itemView.findViewById<ImageView>(R.id.deleteButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {

        val viewHolder=  NoteViewHolder(LayoutInflater.from(context).inflate(R.layout.item_note,parent,false))

        viewHolder.deleteButton.setOnClickListener {
            listener.onItemClicked(allNotes[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {

        val currentNote=allNotes[position]
        holder.textView.text= currentNote.text
       // holder.textView1.text= currentNote.text


    }
    fun updateList(newList:List<Note>)
    {
        allNotes.clear()
        allNotes.addAll(newList)
        notifyDataSetChanged()
    }


    override fun getItemCount(): Int {
        return allNotes.size
    }
}
interface  INotesRVAdapter{
    fun onItemClicked(note:Note)
}