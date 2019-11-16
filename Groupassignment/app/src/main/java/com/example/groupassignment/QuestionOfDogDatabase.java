package com.example.groupassignment;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {QuestionOfDog.class}, version = 1)
public abstract class QuestionOfDogDatabase extends RoomDatabase {
    public abstract QuestionOfDogDao getQuestionOfDogDao();
}
