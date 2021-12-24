package com.example.mynotesx;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class NoteActivity extends AppCompatActivity {

    public static final String NOTES_ID = "id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        NoteFragment fragment  = (NoteFragment)
                getSupportFragmentManager().findFragmentById(R.id.note_fragment);
        int notesId = (int) getIntent().getExtras().get(NOTES_ID);
        fragment.setNote(notesId);
    }

}