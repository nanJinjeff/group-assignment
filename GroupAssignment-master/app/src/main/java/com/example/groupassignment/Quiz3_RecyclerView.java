package com.example.groupassignment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import java.util.List;

import static android.preference.PreferenceManager.getDefaultSharedPreferences;

public class Quiz3_RecyclerView extends AppCompatActivity {

    RecyclerView recyclerView1;
    Button button8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz3_recyclerview);

        button8 = findViewById(R.id.button8);

        //get the question material from the questionDatabase
        final QuestionOfDogDatabase questionDatabase = Room.databaseBuilder(this, QuestionOfDogDatabase.class, "database_question").allowMainThreadQueries()
                .build();
        final List<QuestionOfDog> questionOfDog = questionDatabase.getQuestionOfDogDao().getAllQuestionOfDog();

        //this recyclerView will indicate the fill blank question item.
        recyclerView1 = findViewById(R.id.recyclerView1);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView1.setLayoutManager(linearLayoutManager);
        Quiz3ViewAdapter quiz3ViewAdapter = new Quiz3ViewAdapter(questionOfDog);
        recyclerView1.setAdapter(quiz3ViewAdapter);

        /*this button will be used to translate the score to get the getTheScore.class, and this score will be put in the scoreDatabase.
        the type of quiz is also will be put in the scoreDatabase*/
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //this data in the sharepreferences will be used to calculate the total score.
                SharedPreferences sharedPreferences = getDefaultSharedPreferences(v.getContext());
                int score1 = sharedPreferences.getInt("score1", 0);
                int score2 = sharedPreferences.getInt("score2", 0);
                int score3 = sharedPreferences.getInt("score3", 0);
                int score4 = sharedPreferences.getInt("score4", 0);
                int score5 = sharedPreferences.getInt("score5", 0);
                int score6 = sharedPreferences.getInt("score6", 0);
                int score7 = sharedPreferences.getInt("score7", 0);
                int score8 = sharedPreferences.getInt("score8", 0);
                int score9 = sharedPreferences.getInt("score9", 0);
                int score10 = sharedPreferences.getInt("score10", 0);
                int totalScore = score1+score2+score3+score4+score5+score6+score7+score8+score9+score10;
                ScoreDatabase scoreDatabase = Room.databaseBuilder(v.getContext(), ScoreDatabase.class, "database_score").allowMainThreadQueries()
                        .build();
                Score scoreData = new Score();
                scoreData.setScore(totalScore);
                scoreData.setQuestiontype("Fill blank");
                scoreDatabase.getScoreDao().insertScore(scoreData);

                sharedPreferences.edit().putInt("score1",0).apply();
                sharedPreferences.edit().putInt("score2",0).apply();
                sharedPreferences.edit().putInt("score3",0).apply();
                sharedPreferences.edit().putInt("score4",0).apply();
                sharedPreferences.edit().putInt("score5",0).apply();
                sharedPreferences.edit().putInt("score6",0).apply();
                sharedPreferences.edit().putInt("score7",0).apply();
                sharedPreferences.edit().putInt("score8",0).apply();
                sharedPreferences.edit().putInt("score9",0).apply();
                sharedPreferences.edit().putInt("score10",0).apply();

                Intent intent1 = new Intent(v.getContext(), GetTheScore.class);
                intent1.putExtra("score", totalScore);
                v.getContext().startActivity(intent1);
            }
        });
    }
}