package com.example.groupassignment;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.groupassignment.R;

public class DogViewHolder extends RecyclerView.ViewHolder{

        TextView textView2;


        public DogViewHolder(View view){
            super(view);

            textView2 = view.findViewById(R.id.textView2);

        }
    }

