package com.example.groupassignment;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import static android.content.Intent.ACTION_VIEW;


/**
 * A simple {@link Fragment} subclass.
 */
public class LevelFragment extends Fragment {

    RecyclerView recyclerView;
    Button button2, button4;
    TextView textView27;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_level, container, false);

        textView27 = view.findViewById(R.id.textView27);


        final ScoreDatabase scoreDatabase = Room.databaseBuilder(view.getContext(), ScoreDatabase.class, "database_score").allowMainThreadQueries()
                .build();

        recyclerView = view.findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        ScoreViewAdapter scoreViewAdapter = new ScoreViewAdapter(scoreDatabase.getScoreDao().getAllScore());
        recyclerView.setAdapter(scoreViewAdapter);

        button4 = view.findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int totalScore = 0;
                List<Score> scoreList = scoreDatabase.getScoreDao().getAllScore();

                for(int i = 0; i < scoreList.size(); i++){
                    if(scoreList.get(i).getQuestiontype().equals("Fill blank")){
                        totalScore = scoreList.get(i).getScore() + totalScore;
                    }
                }
                textView27.setText(String.valueOf(totalScore));
            }
        });

        button2 = view.findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.facebook.com/"));
                startActivity(intent);
            }
        });

        return view;
    }

}
