package com.example.groupassignment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static android.preference.PreferenceManager.getDefaultSharedPreferences;

//this adapter will be used for the recyclerView in the quiz3_recyclerView
public class Quiz3ViewAdapter extends RecyclerView.Adapter<Quiz3ViewHolder> {

    //this will be used to set the key in the sharepreferences.
    String scoreNum[] = {"score1", "score2", "score3", "score4", "score5", "score6", "score7", "score8", "score9", "score10"};

public List<QuestionOfDog> question_List;
public int[] score = new int[10];

public Quiz3ViewAdapter(List questionList){
        this.question_List = questionList;
        }

        //put the Quiz3ViewHolder in the recyclerView as the item
@Override
public Quiz3ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_fill_blank, parent, false);
        Quiz3ViewHolder holder = new Quiz3ViewHolder(view);
        return holder;
        }

//set the question content in the Quiz3ViewHolder
@Override
public void onBindViewHolder(final Quiz3ViewHolder holder, final int position) {
    try {
        Glide.with(holder.imageView29).load(question_List.get(position).getDogImage()).into(holder.imageView29);
    }catch (IndexOutOfBoundsException e){
        System.out.println(e.getMessage());
    }
    holder.button29.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String text = String.valueOf(holder.editText29.getText());
            String dogName1 = question_List.get(position).getDogName();
            if(text.toLowerCase().equals(dogName1.toLowerCase())) {
                score[position] = 1;
            }else{
                score[position] = 0;
            }
            SharedPreferences sharedPreferences = getDefaultSharedPreferences(v.getContext());
            sharedPreferences.edit().putInt(scoreNum[position], score[position]).commit();
            Toast.makeText(v.getContext(), "you have submitted this answer", Toast.LENGTH_LONG).show();
        }
    });

}

@Override
public int getItemCount() {
        return question_List.size();
        }
        }


