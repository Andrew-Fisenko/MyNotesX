package com.example.mynotesx;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class NoteFragment extends Fragment {

    private long noteId;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        return inflater.inflate(R.layout.fragment_note, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (view != null) {

            TextView title = (TextView) view.findViewById(R.id.name_note);
            Notes notes = Notes.notes[(int) noteId];
            title.setText(notes.getNameNote());

            TravelCard travelCards = TravelCard.travelCards[(int) noteId];
            int cityImage = TravelCard.travelCards[(int) noteId].getImageResourceId();
            ImageView imageView = (ImageView) view.findViewById(R.id.card_image);
            imageView.setImageDrawable((ContextCompat.getDrawable(getContext(), cityImage)));

            TextView date = (TextView) view.findViewById(R.id.date_note);
            date.setText(notes.getDateNote());

            TextView text = (TextView) view.findViewById(R.id.text_note);
            text.setText(notes.getTextNote());
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu, menu);
        MenuItem item = menu.findItem(R.id.action_about);
        if (item != null) {
            item.setVisible(false);
        }
    }

    public void setNote(long id) {
        this.noteId = id;
    }
}