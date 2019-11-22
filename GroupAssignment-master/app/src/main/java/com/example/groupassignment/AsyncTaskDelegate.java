package com.example.groupassignment;
//the AsyncTaskDelegate has been used to cooperate with the insertDogAsyncTask.
public interface AsyncTaskDelegate {
    void handleTaskResult(String result);
}
