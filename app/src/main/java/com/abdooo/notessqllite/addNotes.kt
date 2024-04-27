package com.abdooo.notessqllite

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.abdooo.notessqllite.databinding.ActivityAddNotes2Binding

class addNotes : AppCompatActivity() {

    private lateinit var binding: ActivityAddNotes2Binding
    private lateinit var db: NotesDataBaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNotes2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        db = NotesDataBaseHelper(this)
        binding.savedButton1.setOnClickListener {
            val title = binding.titleEditText.text.toString()
            val content = binding.contentEditText.text.toString()
            val note = Note(0, title, content)
            db.insertNote(note)
            finish()
            Toast.makeText(this, "Note Saved", Toast.LENGTH_SHORT).show()
        }

    }
}