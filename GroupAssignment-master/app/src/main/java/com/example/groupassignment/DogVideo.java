package com.example.groupassignment;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

public class DogVideo  extends AppCompatActivity {
    private WebView webView;

    @Override
    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dog_video);
        Intent intent = getIntent();
        String dogname = intent.getStringExtra("Dogname");
        String newdogname = dogname.replace(' ','+');
        webView =findViewById(R.id.wb_dogvideo);
        webView.loadUrl("https://www.youtube.com/results?search_query="+newdogname);




    }
}
