package com.example.groupassignment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class NoteFragment extends Fragment {

    RecyclerView recyclerView4;
    TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_note, container, false);
        TextDatabase tdb = Room.databaseBuilder(view.getContext(), TextDatabase.class, "text_database")
                .allowMainThreadQueries().build();


        textView = view.findViewById(R.id.textView);
        recyclerView4 = view.findViewById(R.id.recyclerView4);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView4.setLayoutManager(linearLayoutManager);
        TextAdapterView textAdapterView = new TextAdapterView(tdb.textDao().getTexts());
        recyclerView4.setAdapter(textAdapterView);

        return view;
    }

}
