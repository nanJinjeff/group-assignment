package com.example.groupassignment;

import androidx.room.Database;
import androidx.room.RoomDatabase;


//this will create the text database, and combine the query and insert method and the text entities together.
@Database(entities = {Text.class}, version = 1)
public abstract class TextDatabase extends RoomDatabase {
    public abstract TextDao textDao();
}
