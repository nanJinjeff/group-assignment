package com.example.groupassignment;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Score.class}, version = 1)
public abstract class ScoreDatabase extends RoomDatabase {
    public abstract ScoreDao getScoreDao();
}
