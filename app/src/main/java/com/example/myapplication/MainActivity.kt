package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(),INotesRVAdapter {
    lateinit var viewModel: NoteViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)




        recyclerView.layoutManager=LinearLayoutManager(this)
        val adapter= NotesRvAdapter(this,this)
        recyclerView.adapter= adapter

        viewModel = ViewModelProvider(this,
                ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(NoteViewModel::class.java)

        viewModel.allNotes.observe(this, Observer { list ->
            list?.let {
                adapter.updateList(it)
            }
        })
    }
    override fun onItemClicked(note: Note) {
        viewModel.deleteNode(note)
    }

    fun submitData(view: View) {
        val input = findViewById<TextView>(R.id.input)

     //   val input1 = findViewById<TextView>(R.id.input1)

        val noteText = input.text.toString()
     //   val noteText1 = input1.text.toString()

        if(noteText.isNotEmpty())
        {
            viewModel.insertNote(Note(noteText))
        }
    }
}