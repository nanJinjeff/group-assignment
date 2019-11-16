package com.example.groupassignment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;


public class Quiz2 extends AppCompatActivity {


    TextView textView7,textView8,textView20,textView23,textView24;
    Button button5;
    int[] score = new int[5];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz2);

        textView7 = findViewById(R.id.textView7);
        textView8 = findViewById(R.id.textView8);
        textView20 = findViewById(R.id.textView20);
        textView23 = findViewById(R.id.textView23);
        textView24 = findViewById(R.id.textView24);

        textView7.setText("this dog's name is Azawakh");
        RadioGroup radioGroup1 = findViewById(R.id.radioGroup);
        radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = findViewById(checkedId);
                Toast.makeText(group.getContext(), "you have chosen "+ radioButton.getText(), Toast.LENGTH_LONG ).show();
                switch (checkedId){
                    case R.id.radioButton:
                        score[0] = 1;
                        break;
                    case R.id.radioButton2:
                        score[0] = 0;
                        break;
                }
            }
        });
        textView8.setText("this dog's name is appenzeller_sennenhund");
        RadioGroup radioGroup2 = findViewById(R.id.radioGroup2);
        radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = findViewById(checkedId);
                Toast.makeText(group.getContext(), "you have chosen "+ radioButton.getText(), Toast.LENGTH_LONG ).show();
                switch (checkedId){
                    case R.id.radioButton5:
                        score[1] = 0;
                        break;
                    case R.id.radioButton6:
                        score[1] = 1;
                        break;
                }
            }
        });
        textView20.setText("this dog's name is Basenji");
        RadioGroup radioGroup3 = findViewById(R.id.radioGroup3);
        radioGroup3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = findViewById(checkedId);
                Toast.makeText(group.getContext(), "you have chosen "+ radioButton.getText(), Toast.LENGTH_LONG ).show();
                switch (checkedId){
                    case R.id.radioButton9:
                        score[2] = 1;
                        break;
                    case R.id.radioButton10:
                        score[2] = 0;
                        break;
                }
            }
        });
        textView23.setText("this dog's name is Basset_Bleu_De_Gascogne");
        RadioGroup radioGroup4 = findViewById(R.id.radioGroup4);
        radioGroup4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = findViewById(checkedId);
                Toast.makeText(group.getContext(), "you have chosen "+ radioButton.getText(), Toast.LENGTH_LONG ).show();
                switch (checkedId){
                    case R.id.radioButton13:
                        score[3] = 1;
                        break;
                    case R.id.radioButton14:
                        score[3] = 0;
                        break;
                }
            }
        });
        textView24.setText("this dog's name is Basset_Hound");
        RadioGroup radioGroup5 = findViewById(R.id.radioGroup5);
        radioGroup5.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = findViewById(checkedId);
                Toast.makeText(group.getContext(), "you have chosen "+ radioButton.getText(), Toast.LENGTH_LONG ).show();
                switch (checkedId){
                    case R.id.radioButton:
                        score[4] = 0;
                        break;
                    case R.id.radioButton2:
                        score[4] = 1;
                        break;
                }
            }
        });

        button5 = findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ScoreDatabase scoreDatabase = Room.databaseBuilder(v.getContext(), ScoreDatabase.class, "database_score").allowMainThreadQueries()
                        .build();
                Score scoreData = new Score();
                int scoreTotal = score[0]+score[1]+score[2]+score[3]+score[4];
                scoreData.setScore(scoreTotal);
                scoreData.setQuestiontype("True or False");
                scoreDatabase.getScoreDao().insertScore(scoreData);
                Intent intent = new Intent(v.getContext(), GetTheScore.class);
                intent.putExtra("score", scoreTotal);
                v.getContext().startActivity(intent);
            }
        });
    }
}
