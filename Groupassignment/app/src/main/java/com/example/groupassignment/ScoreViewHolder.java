package com.example.groupassignment;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.groupassignment.R;

public class ScoreViewHolder extends RecyclerView.ViewHolder {

    TextView textView4;
    TextView textView26;

    public ScoreViewHolder(View view){
        super(view);
        textView4 = view.findViewById(R.id.textView4);
        textView26 = view.findViewById(R.id.textView26);
    }

}
