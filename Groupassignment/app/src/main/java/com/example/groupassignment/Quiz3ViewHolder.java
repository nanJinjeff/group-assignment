package com.example.groupassignment;

import android.media.Image;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class Quiz3ViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView29;
    EditText editText29;
    Button button29;

    public Quiz3ViewHolder(View view){
        super(view);
        imageView29 = view.findViewById(R.id.imageView29);
        editText29 = view.findViewById(R.id.editText29);
        button29 = view.findViewById(R.id.button29);
    }

}
