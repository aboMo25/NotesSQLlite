package com.abdooo.notessqllite

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.abdooo.notessqllite.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var db:NotesDataBaseHelper
    private lateinit var notesAdapter: NotesAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        db= NotesDataBaseHelper(this)
        notesAdapter= NotesAdapter(db.getAllNotes(),this)
        binding.RecyclerNotes.layoutManager=LinearLayoutManager(this)
        binding.RecyclerNotes.adapter=notesAdapter


        binding.addButton.setOnClickListener{
            val intent=Intent(this,addNotes::class.java)
            startActivity(intent)
        }

        }

    override fun onResume() {
        super.onResume()
        notesAdapter.refreshData(db.getAllNotes())
    }

    }
