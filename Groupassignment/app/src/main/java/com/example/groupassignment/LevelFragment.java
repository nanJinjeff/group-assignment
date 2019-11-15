package com.example.groupassignment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class LevelFragment extends Fragment {

    RecyclerView recyclerView;
    Button button2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_level, container, false);

        ScoreDatabase scoreDatabase = Room.databaseBuilder(view.getContext(), ScoreDatabase.class, "database_score").allowMainThreadQueries()
                .build();

        recyclerView = view.findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        ScoreViewAdapter scoreViewAdapter = new ScoreViewAdapter(scoreDatabase.getScoreDao().getAllScore());
        recyclerView.setAdapter(scoreViewAdapter);

        button2 = view.findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return view;
    }

}
