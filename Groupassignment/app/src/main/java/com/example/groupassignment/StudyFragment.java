package com.example.groupassignment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class StudyFragment extends Fragment {
    RecyclerView recyclerView1;
    public SearchView searchView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_study, container, false);


        searchView = view.findViewById(R.id.searchView);

        searchView.setSubmitButtonEnabled(true);

        recyclerView1 = view.findViewById(R.id.recyclerView1);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
        recyclerView1.setLayoutManager(linearLayoutManager);


        String url = "https://api.TheDogApi.com/v1/breeds?";
        RequestQueue requestQueue = Volley.newRequestQueue(view.getContext());

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Gson gson = new Gson();
                Dog[] objectsArray = gson.fromJson(response, Dog[].class);
                final List<Dog> objectsList = Arrays.asList(objectsArray);

                DogViewAdapter catViewAdapter = new DogViewAdapter(objectsList);
                recyclerView1.setAdapter(catViewAdapter);

                searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                    @Override
                    public boolean onQueryTextSubmit(String query) {
                        DogViewAdapter dogViewAdapter = new DogViewAdapter(getDogList(query, objectsList));
                        recyclerView1.setAdapter(dogViewAdapter);
                        return false;
                    }

                    @Override
                    public boolean onQueryTextChange(String newText) {
                        DogViewAdapter dogViewAdapter = new DogViewAdapter(getDogList(newText,objectsList));
                        recyclerView1.setAdapter(dogViewAdapter);
                        return false;
                    }
                });

            }

        };

        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("The request failed.");
            }
        };

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, responseListener, errorListener);

        requestQueue.add(stringRequest);

        return view;
    }

    public ArrayList<Dog> getDogList(String input, List<Dog> list){
        ArrayList<Dog> newArrayList = new ArrayList<>();
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i).getName().toLowerCase().contains(input.toLowerCase())){
                newArrayList.add(list.get(i));
            }
        }
        return newArrayList;
    }
}



