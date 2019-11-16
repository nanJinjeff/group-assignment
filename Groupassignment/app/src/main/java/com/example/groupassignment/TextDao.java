package com.example.groupassignment;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;


import java.util.List;

@Dao
public interface TextDao {
    @Query("SELECT * FROM Text")
    List<Text> getTexts();

    @Query("SELECT * FROM Text WHERE id = :id")
    Text getTextById(int id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Text text);

    @Delete
    void delete(Text text);

}