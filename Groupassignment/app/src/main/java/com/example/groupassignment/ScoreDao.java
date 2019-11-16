package com.example.groupassignment;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;


import java.util.List;

@Dao
public interface ScoreDao {

    @Query("SELECT * FROM Score ORDER BY score ASC")
    List<Score> getAllScore();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertScore(Score score);

}
