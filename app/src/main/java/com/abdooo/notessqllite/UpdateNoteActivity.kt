package com.abdooo.notessqllite

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.abdooo.notessqllite.databinding.ActivityUpdateNoteBinding

class UpdateNoteActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUpdateNoteBinding
    private lateinit var db:NotesDataBaseHelper
    // means that data base is empty
    private  var noteId=-1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityUpdateNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db= NotesDataBaseHelper(this)

        noteId=intent.getIntExtra("note_id",-1)
        if (noteId==-1){
            finish()
            return
        }

        val note=db.getNoteById(noteId)
        binding.updatetitleEditText.setText(note.title)
        binding.updatecontentEditText.setText(note.content)

        binding.updatesavedButton1.setOnClickListener{
            val newTitle=binding.updatetitleEditText.text.toString()
            val newContent=binding.updatecontentEditText.text.toString()
            val updateNote=Note(noteId,newTitle,newContent)
            db.updateNote(updateNote)
            finish()

            Toast.makeText(this,"Changes Saved",Toast.LENGTH_SHORT).show()

        }


    }
}