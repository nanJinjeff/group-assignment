package com.example.groupassignment;

import androidx.room.Database;
import androidx.room.RoomDatabase;

//create a database for question material. the purpose is to combine the table and query and insert data method.
@Database(entities = {QuestionOfDog.class}, version = 1)
public abstract class QuestionOfDogDatabase extends RoomDatabase {
    public abstract QuestionOfDogDao getQuestionOfDogDao();
}
