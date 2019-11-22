package com.example.groupassignment;

import android.os.AsyncTask;


import java.util.Arrays;
//this class will be used to put the delegate and database, the purpose is the to store the api data into the database.
public class InsertDogAsyncTask extends AsyncTask<Dog, Integer, String> {

    private AsyncTaskDelegate delegate;
    private DogDatabase database;

    public void setDelegate(AsyncTaskDelegate delegate){
        this.delegate = delegate;
    }

    public void setDatabase(DogDatabase database){
        this.database = database;
    }

    @Override
    protected String doInBackground(Dog... dogs){
        database.dogDao().insertDog(Arrays.asList(dogs));
        return "Please find your interested dog or search by dog name";
    }

    @Override
    protected void onPostExecute(String result){
        delegate.handleTaskResult(result);
    }

}
