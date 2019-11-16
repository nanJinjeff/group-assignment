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



public class Quiz extends AppCompatActivity {

    Button button5;
    TextView textView7,textView8, textView20, textView23, textView24;
    int[] score = new int[5];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz);

        textView7 = findViewById(R.id.textView7);
        textView8 = findViewById(R.id.textView8);
        textView20 = findViewById(R.id.textView20);
        textView23 = findViewById(R.id.textView23);
        textView24 = findViewById(R.id.textView24);

        textView7.setText("which dog's name is Affenpinshcher");
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
                    case R.id.radioButton3:
                        score[0] = 0;
                        break;
                    case R.id.radioButton4:
                        score[0] = 0;
                        break;
                }
            }
        });
        textView8.setText("which dog's name is Alapaha_Blue_Blood_Building");
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
                        score[1] = 0;
                        break;
                    case R.id.radioButton7:
                        score[1] = 1;
                        break;
                    case R.id.radioButton8:
                        score[1] = 0;
                        break;
                }
            }
        });
        textView20.setText("which dog's name is American_Bulldog");
        RadioGroup radioGroup3 = findViewById(R.id.radioGroup3);
        radioGroup3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = findViewById(checkedId);
                Toast.makeText(group.getContext(), "you have chosen "+ radioButton.getText(), Toast.LENGTH_LONG ).show();
                switch (checkedId){
                    case R.id.radioButton9:
                        score[2] = 0;
                        break;
                    case R.id.radioButton10:
                        score[2] = 1;
                        break;
                    case R.id.radioButton11:
                        score[2] = 0;
                        break;
                    case R.id.radioButton12:
                        score[2] = 0;
                        break;
                }
            }
        });
        textView23.setText("which dog's name is American_Eskimo_Dog_Miniature");
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
                    case R.id.radioButton15:
                        score[3] = 0;
                        break;
                    case R.id.radioButton16:
                        score[3] = 0;
                        break;
                }
            }
        });
        textView24.setText("which dog's name is Australian_Terrier");
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
                        score[4] = 0;
                        break;
                    case R.id.radioButton3:
                        score[4] = 0;
                        break;
                    case R.id.radioButton4:
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
                scoreData.setQuestiontype("Multiple choice");
                scoreDatabase.getScoreDao().insertScore(scoreData);
                Intent intent = new Intent(v.getContext(), GetTheScore.class);
                intent.putExtra("score", scoreTotal);
                v.getContext().startActivity(intent);
            }
        });
    }
}
