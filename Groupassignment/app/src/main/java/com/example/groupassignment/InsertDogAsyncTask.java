package com.example.groupassignment;

import android.os.AsyncTask;


import java.util.Arrays;

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
        return "you can choose and search many dogs to study";
    }

    @Override
    protected void onPostExecute(String result){
        delegate.handleTaskResult(result);
    }

}
