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
import android.widget.Toast;

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

//implement AsyncTaskDelegate to use the database.
public class StudyFragment extends Fragment implements AsyncTaskDelegate,AsyncTaskGetDelegate {
    RecyclerView recyclerView1;
    public SearchView searchView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_study, container, false);

        searchView = view.findViewById(R.id.searchView);
        searchView.setSubmitButtonEnabled(true);

        //set the dog api url.
        final String url = "https://api.TheDogApi.com/v1/breeds?";
        //use the volley to get the dog api.
        final RequestQueue requestQueue = Volley.newRequestQueue(view.getContext());

        final StudyFragment studyFragment = this;

        //response listener object in the volley.
        final Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                //the method of Gson
                Gson gson = new Gson();

                //response is the returned api. and store it in the Dog array.
                Dog[] objectsArray = gson.fromJson(response, Dog[].class);

                //use the dogDatabase to store the the got api. this database will be put in the insertDogAsyncTask.
                final DogDatabase dogDB = Room.databaseBuilder(view.getContext(), DogDatabase.class, "database_dog").allowMainThreadQueries()
                        .build();



                //use the insertDogAsyncTask to set the delegate, database and put the array in insertDogAsyncTask.
                InsertDogAsyncTask insertDogAsyncTask = new InsertDogAsyncTask();
                insertDogAsyncTask.setDatabase(dogDB);
                insertDogAsyncTask.setDelegate(studyFragment);
                insertDogAsyncTask.execute(objectsArray);

                //use recyclerView to indicate data.
                recyclerView1 = view.findViewById(R.id.recyclerView1);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
                recyclerView1.setLayoutManager(linearLayoutManager);


                //use search view to select item which is in the recyclerView.
                searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                    @Override
                    public boolean onQueryTextSubmit(String query) {
                        DogViewAdapter dogViewAdapter = new DogViewAdapter(getDogList(query, dogDB.dogDao().getAllDogs()));
                        recyclerView1.setAdapter(dogViewAdapter);
                        return false;
                    }

                    @Override
                    public boolean onQueryTextChange(String newText) {
                        DogViewAdapter dogViewAdapter = new DogViewAdapter(getDogList(newText, dogDB.dogDao().getAllDogs()));
                        recyclerView1.setAdapter(dogViewAdapter);
                        return false;
                    }
                });
            }
        };


        //the response.errorListener method in the volley has been used, when there is a failed request.
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


    @Override
    public void handleTaskResult(String result){
        Toast.makeText(getContext(), result, Toast.LENGTH_LONG).show();
        DogDatabase dogDB = Room.databaseBuilder(getContext(), DogDatabase.class, "database_dog").allowMainThreadQueries()
                .build();
        GetDogAsyncTask getDogAsyncTask = new GetDogAsyncTask();
        getDogAsyncTask.setDatabase(dogDB);
        getDogAsyncTask.setDelegate(this);
        getDogAsyncTask.execute();
    }

    @Override
    public void handleTaskGetResult(List<Dog> dogs){
        DogViewAdapter dogViewAdapter = new DogViewAdapter(dogs);
        recyclerView1.setAdapter(dogViewAdapter);
    }

    //create a method to filter the searched item
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



