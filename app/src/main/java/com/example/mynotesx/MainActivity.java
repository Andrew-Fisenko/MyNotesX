package com.example.mynotesx;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.TintableCheckedTextView;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements NoteListFragment.Listener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
}