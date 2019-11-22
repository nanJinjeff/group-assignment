package com.example.groupassignment;

import androidx.room.Database;
import androidx.room.RoomDatabase;

//the class is to make a room database, to combine the entities (dog class) and interface(query and insert data) to the database.
@Database(entities = {Dog.class}, version = 1)
public abstract class DogDatabase extends RoomDatabase {
    public abstract DogDao dogDao();
}
