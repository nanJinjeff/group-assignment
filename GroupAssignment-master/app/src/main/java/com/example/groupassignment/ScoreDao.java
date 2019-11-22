package com.example.groupassignment;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;


import java.util.List;

//this will be the query and insert data method for the scoreDatabase.
@Dao
public interface ScoreDao {

    @Query("SELECT * FROM Score ORDER BY score ASC")
    List<Score> getAllScore();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertScore(Score score);

    @Delete
    void deleteAll(List<Score> scores);

}
