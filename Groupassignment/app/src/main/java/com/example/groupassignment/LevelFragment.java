package com.example.groupassignment;


import android.content.Context;
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
import android.widget.Toast;

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
        final QuestionOfDogDatabase questionDatabase = Room.databaseBuilder(view.getContext(), QuestionOfDogDatabase.class, "database_question").allowMainThreadQueries()
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
                int timesDifficult = 0;
                for(int i = 0 ; i < scoreDatabase.getScoreDao().getAllScore().size(); i++){
                    if(scoreDatabase.getScoreDao().getAllScore().get(i).getQuestiontype().equals("Fill blank")){
                        totalScore = scoreDatabase.getScoreDao().getAllScore().get(i).getScore() + totalScore;
                        timesDifficult++;
                    }
                }
                textView27.setText("you have done difficult quiz "+ timesDifficult + " times," + " total mark is " + totalScore + ", you have studied " + questionDatabase.getQuestionOfDogDao().getAllQuestionOfDog().size() + " (dog)");
                try {
                    scoreDatabase.getScoreDao().deleteAll(scoreDatabase.getScoreDao().getAllScore());
                }catch (NullPointerException e){
                   e.getMessage();
                }
            }
        });

        button2 = view.findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                context.startActivity(intent);
            }
        });
        return view;
    }

}
