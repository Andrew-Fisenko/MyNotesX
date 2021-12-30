package com.example.mynotesx;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.content.Intent;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class NoteCardFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        RecyclerView cardRecycler = (RecyclerView)inflater.inflate(
                R.layout.fragment_card, container, false);

        String[] cardNames = new String[TravelCard.travelCards.length];
        for (int i = 0; i < cardNames.length; i++) {
            cardNames[i] = TravelCard.travelCards[i].getName();
        }

        int[] cardImages = new int[TravelCard.travelCards.length];
        for (int i = 0; i < cardImages.length; i++) {
            cardImages[i] = TravelCard.travelCards[i].getImageResourceId();
        }

        CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(cardNames, cardImages);
        cardRecycler.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        cardRecycler.setLayoutManager(layoutManager);

        adapter.setListener(new CaptionedImagesAdapter.Listener() {
            public void onClick(int position) {
                Intent intent = new Intent(getActivity(), NoteActivity.class);
                intent.putExtra(NoteActivity.NOTES_ID, position);
                getActivity().startActivity(intent);
            }
        });

        return cardRecycler;

    }
}