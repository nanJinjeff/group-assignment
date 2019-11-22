package com.example.groupassignment;

import android.os.AsyncTask;

import java.util.List;

public class GetDogAsyncTask extends AsyncTask<Void, Integer, List<Dog>> {

    private AsyncTaskGetDelegate delegate;

    private DogDatabase database;

    public void setDelegate(AsyncTaskGetDelegate delegate) {
        this.delegate = delegate;
    }

    public void setDatabase(DogDatabase database) {
        this.database = database;
    }

    @Override
    protected List<Dog> doInBackground(Void... voids) {
        return database.dogDao().getAllDogs();
    }

    @Override
    protected void onPostExecute(List<Dog> result) {

        delegate.handleTaskGetResult(result);
    }
}
