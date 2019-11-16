package com.example.groupassignment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ScoreViewAdapter extends RecyclerView.Adapter<ScoreViewHolder>   {


    public List<Score> score_List;

    public ScoreViewAdapter(List scoreList){
        this.score_List = scoreList;
    }

    @Override
    public ScoreViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_score, parent, false);
        ScoreViewHolder holder = new ScoreViewHolder(view);
        return holder;
    }


    @Override
    public void onBindViewHolder(final ScoreViewHolder holder, final int position) {
        holder.textView4.setText(String.valueOf(score_List.get(position).getScore()));
        holder.textView26.setText(score_List.get(position).getQuestiontype());
    }

    @Override
    public int getItemCount() {
        return score_List.size();
    }
}
