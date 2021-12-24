package com.example.mynotesx;

import androidx.annotation.NonNull;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.TintableCheckedTextView;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements NoteListFragment.Listener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Button addNote = findViewById(R.id.add_note);
        addNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Add note", Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public void itemClicked(long id) {
        View fragmentContainer = findViewById(R.id.fragment_container);
        if (fragmentContainer != null) {
            NoteFragment fragment = new NoteFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            fragment.setNote(id);
            transaction.replace(R.id.fragment_container, fragment);
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            transaction.addToBackStack(null);
            transaction.commit();
        } else {
            Intent intent = new Intent(this, NoteActivity.class);
            intent.putExtra(NoteActivity.NOTES_ID, (int) id);
            startActivity(intent);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_find:
                Toast.makeText(getApplicationContext(), "Find note", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_send:
                Toast.makeText(getApplicationContext(), "Send note", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_about:
                Toast.makeText(getApplicationContext(), "About app", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_exit:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}