package com.example.groupassignment;

import androidx.room.Database;
import androidx.room.RoomDatabase;



@Database(entities = {Text.class}, version = 1)
public abstract class TextDatabase extends RoomDatabase {
    public abstract TextDao textDao();
}
