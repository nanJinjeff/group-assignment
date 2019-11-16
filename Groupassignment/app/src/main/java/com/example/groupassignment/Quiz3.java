package com.example.groupassignment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.bumptech.glide.Glide;

import java.util.List;

public class Quiz3 extends AppCompatActivity {


    Button button5, button29, button30, button31, button32, button33;
    ImageView imageView29, imageView30, imageView31, imageView32, imageView33;
    EditText editText29, editText30, editText31, editText32, editText33;
    TextView textView29, textView30, textView31, textView32, textView33;
    int[] score = new int[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz3);

        final QuestionOfDogDatabase questionDatabase = Room.databaseBuilder(this, QuestionOfDogDatabase.class, "database_question").allowMainThreadQueries()
                .build();

        final List<QuestionOfDog> questionOfDog = questionDatabase.getQuestionOfDogDao().getAllQuestionOfDog();
        final int num = questionOfDog.size();

        final int num1 = (int)(Math.random()*num);
        imageView29 = findViewById(R.id.imageView29);
        editText29 = findViewById(R.id.editText29);
        textView29 = findViewById(R.id.textView29);
        button29 = findViewById(R.id.button29);
        try {
            Glide.with(this).load(questionOfDog.get(num1).getDogImage()).into(imageView29);
        }catch (IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
        button29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = String.valueOf(editText29.getText());
                String dogName1 = questionOfDog.get(num1).getDogName();
                textView29.setText(text);
                String textView = String.valueOf(textView29.getText());
                if(textView.toLowerCase().equals(dogName1.toLowerCase())) {
                    score[0] = 1;
                }else{
                    score[0] = 0;
                }
                Toast.makeText(v.getContext(), "you have submitted this answer", Toast.LENGTH_LONG).show();
            }
        });


        final int num2 = (int)(Math.random()*num);
        imageView30 = findViewById(R.id.imageView30);
        editText30 = findViewById(R.id.editText30);
        textView30 = findViewById(R.id.textView30);
        button30 = findViewById(R.id.button30);
        try {
            Glide.with(this).load(questionOfDog.get(num2).getDogImage()).into(imageView30);
        }catch (IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
        button30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = String.valueOf(editText30.getText());
                String dogName2 = questionOfDog.get(num2).getDogName();
                textView30.setText(text);
                String textView = String.valueOf(textView30.getText());
                if(textView.toLowerCase().equals(dogName2.toLowerCase())) {
                    score[1] = 1;
                }else{
                    score[1] = 0;
                }
                Toast.makeText(v.getContext(), "you have submitted this answer", Toast.LENGTH_LONG).show();
            }
        });


        final int num3 = (int)(Math.random()*num);
        imageView31 = findViewById(R.id.imageView31);
        editText31 = findViewById(R.id.editText31);
        textView31 = findViewById(R.id.textView31);
        button31 = findViewById(R.id.button31);
        try {
            Glide.with(this).load(questionOfDog.get(num3).getDogImage()).into(imageView31);
        }catch (IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
        button31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = String.valueOf(editText31.getText());
                String dogName3 = questionOfDog.get(num3).getDogName();
                textView31.setText(text);
                String textView = String.valueOf(textView31.getText());
                if(textView.toLowerCase().equals(dogName3.toLowerCase())) {
                    score[2] = 1;
                }else{
                    score[2] = 0;
                }
                Toast.makeText(v.getContext(), "you have submitted this answer", Toast.LENGTH_LONG).show();
            }
        });


        final int num4 = (int)(Math.random()*num);
        imageView32 = findViewById(R.id.imageView32);
        editText32 = findViewById(R.id.editText32);
        textView32 = findViewById(R.id.textView32);
        button32 = findViewById(R.id.button32);
        try {
            Glide.with(this).load(questionOfDog.get(num4).getDogImage()).into(imageView32);
        }catch (IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
        button32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = String.valueOf(editText32.getText());
                String dogName4 = questionOfDog.get(num4).getDogName();
                textView32.setText(text);
                String textView = String.valueOf(textView32.getText());
                if(textView.toLowerCase().equals(dogName4.toLowerCase())) {
                    score[3] = 1;
                }else{
                    score[3] = 0;
                }
                Toast.makeText(v.getContext(), "you have submitted this answer", Toast.LENGTH_LONG).show();
            }
        });


        final int num5 = (int)(Math.random()*num);
        imageView33 = findViewById(R.id.imageView33);
        editText33 = findViewById(R.id.editText33);
        textView33 = findViewById(R.id.textView33);
        button33 = findViewById(R.id.button33);
        try {
            Glide.with(this).load(questionOfDog.get(num5).getDogImage()).into(imageView33);
        }catch (IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
        button33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = String.valueOf(editText33.getText());
                String dogName5 = questionOfDog.get(num5).getDogName();
                textView33.setText(text);
                String textView = String.valueOf(textView33.getText());
               if(textView.toLowerCase().equals(dogName5.toLowerCase())) {
                   score[4] = 1;
               }else{
                   score[4] = 0;
               }
                Toast.makeText(v.getContext(), "you have submitted this answer", Toast.LENGTH_LONG).show();
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
                scoreData.setQuestiontype("Fill blank");
                scoreDatabase.getScoreDao().insertScore(scoreData);
                Intent intent = new Intent(v.getContext(), GetTheScore.class);
                intent.putExtra("score", scoreTotal);
                v.getContext().startActivity(intent);
            }
        });
    }
}