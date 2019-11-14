package com.example.groupassignment;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Insert;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;

public class DogDescription extends AppCompatActivity{

    TextView textView9,textView13,textView19,
            textView15, textView11,textView17;
    EditText editText24;
    ImageView imageView3;
    Button button, button6;
    String urlImage;
    String dogName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dog_description);

        final Intent intent = getIntent();
        final int dogNum = intent.getIntExtra("dogNum", 0);
        final String dogName = intent.getStringExtra("dogName");


        imageView3 = findViewById(R.id.imageView3);
        textView9 = findViewById(R.id.textView9);

        textView13 = findViewById(R.id.textView13);
        textView15 = findViewById(R.id.textView15);


        textView11 = findViewById(R.id.textView11);
        textView17 = findViewById(R.id.textView17);

        textView19 = findViewById(R.id.textView19);

        button6 = findViewById(R.id.button6);
        editText24 = findViewById(R.id.editText24);

        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextDatabase textDatabase = Room.databaseBuilder(v.getContext(), TextDatabase.class, "text_database")
                        .allowMainThreadQueries().build();

                Text text = new Text();
                text.setText_topic(String.valueOf(textView9.getText()));
                text.setText_content(String.valueOf(editText24.getText()));
                textDatabase.textDao().insert(text);

                String notify = "you have added a Note";
                Toast.makeText(v.getContext(), notify, Toast.LENGTH_LONG).show();
            }
        });

        String url = "https://api.TheDogApi.com/v1/breeds";

        RequestQueue requestQueue = Volley.newRequestQueue(this);

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                final Gson gson = new Gson();
                Dog[] objectsArray = gson.fromJson(response, Dog[].class);
                final List<Dog> objectsList = Arrays.asList(objectsArray);



                textView9.setText(objectsList.get(dogNum).getName());
                textView13.setText(objectsList.get(dogNum).getOrigin());
                textView15.setText(objectsList.get(dogNum).getLife_span());
                textView11.setText(objectsList.get(dogNum).getBred_for());
                textView17.setText(objectsList.get(dogNum).getBreed_group());
                textView19.setText(objectsList.get(dogNum).getTemperament());

            }
        };

        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("The request failed.");
            }
        };



        final String search = "https://en.wikipedia.org/wiki/"+ dogName;
        button6.setText(search);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Intent.ACTION_VIEW);
                intent1.setData(Uri.parse(search));
                startActivity(intent1);
            }
        });


        Intent intent1 = getIntent();
        String urlID = String.valueOf(intent1.getIntExtra("urlID", 0));
        urlImage = "https://api.TheDogApi.com/v1/images/search?breed_ids="+urlID;

         Response.Listener<String> responseListener1 = new Response.Listener<String>() {
             @Override
             public void onResponse(String response) {
                 final Gson gson = new Gson();
                 DogImage[] objectsArrayCatImage = gson.fromJson(response, DogImage[].class);
                 List<DogImage> objectsImageList = Arrays.asList(objectsArrayCatImage);

                 if (objectsImageList.get(0).getUrl() != null) {
                     Glide.with(getApplicationContext()).load(objectsImageList.get(0).getUrl()).into(imageView3);
                 }
             }

         };

             Response.ErrorListener errorListener1 = new Response.ErrorListener() {
                 @Override
                 public void onErrorResponse(VolleyError error) {
                     System.out.println("The request failed.");
                 }
             };

             StringRequest stringRequest = new StringRequest(Request.Method.GET, url, responseListener, errorListener);
             StringRequest stringRequest1 = new StringRequest(Request.Method.GET, urlImage, responseListener1, errorListener1);
             requestQueue.add(stringRequest);
             requestQueue.add(stringRequest1);

         }
}