package com.example.groupassignment;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.room.Room;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


public class QuizFragment extends Fragment {

    ImageButton imageButton1;
    ImageButton imageButton2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_quiz, container, false);



        final Score score = new Score();

        imageButton1 = view.findViewById(R.id.imageButton1);
        imageButton2 = view.findViewById(R.id.imageButton2);

        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(v.getContext(), Quiz.class);
                v.getContext().startActivity(intent1);
            }
        });

        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(v.getContext(), Quiz2.class);
                v.getContext().startActivity(intent2);
            }
        });
        return view;
    }

}
