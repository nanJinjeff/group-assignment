package com.example.groupassignment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GetTheScore extends AppCompatActivity {

    TextView textView21;
    Button button7;
    TextView TextView25;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.get_the_score);

        TextView25 = findViewById(R.id.textView25);
      textView21 = findViewById(R.id.textView21);
      button7 = findViewById(R.id.button7);


        Intent intent = getIntent();
        int score = intent.getIntExtra("score", 1);
        textView21.setText(String.valueOf(score));

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(v.getContext(), MainActivity.class);
                v.getContext().startActivity(intent1);
            }
        });
    }
}

