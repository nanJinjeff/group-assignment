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
    TextView textView27, textView29;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_level, container, false);

        textView27 = view.findViewById(R.id.textView27);
        textView29 = view.findViewById(R.id.textView29);

        final ScoreDatabase scoreDatabase = Room.databaseBuilder(view.getContext(), ScoreDatabase.class, "database_score").allowMainThreadQueries()
                .build();
        final QuestionOfDogDatabase questionDatabase = Room.databaseBuilder(view.getContext(), QuestionOfDogDatabase.class, "database_question").allowMainThreadQueries()
                .build();

        textView29.setText("Congratulations! you have learnt "+questionDatabase.getQuestionOfDogDao().getAllQuestionOfDog().size() +" dogs");

        //this recyclerView is to indicate the quiz result in a form of recording.
        recyclerView = view.findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        ScoreViewAdapter scoreViewAdapter = new ScoreViewAdapter(scoreDatabase.getScoreDao().getAllScore());
        recyclerView.setAdapter(scoreViewAdapter);

        //this button will be used to clear the record and calculate the total difficult quiz score.
        button4 = view.findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int totalScore = 0;
                int times = 0;
                for(int i = 0 ; i < scoreDatabase.getScoreDao().getAllScore().size(); i++){
                        totalScore = scoreDatabase.getScoreDao().getAllScore().get(i).getScore() + totalScore;
                        times++;
                }
                textView27.setText("you have done quiz "+ times + " times," + " total mark is " + totalScore);
                try {
                    scoreDatabase.getScoreDao().deleteAll(scoreDatabase.getScoreDao().getAllScore());
                }catch (NullPointerException e){
                   e.getMessage();
                }
            }
        });

        //this is the share button, which will be used to share score.
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
