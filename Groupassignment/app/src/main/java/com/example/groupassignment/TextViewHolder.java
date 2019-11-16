package com.example.groupassignment;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.groupassignment.R;

public class TextViewHolder extends RecyclerView.ViewHolder {
    TextView textView3;
    TextView textView5;
    Button button3;

    public TextViewHolder(View view){
        super(view);
        textView3 = view.findViewById(R.id.textView3);
        textView5 = view.findViewById(R.id.textView5);
        button3 = view.findViewById(R.id.button3);
    }
}
