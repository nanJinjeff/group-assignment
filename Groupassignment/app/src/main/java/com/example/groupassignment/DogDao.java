package com.example.groupassignment;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;



import java.util.List;

@Dao
public interface DogDao {

    @Query("SELECT * FROM Dog")
    List<Dog> getAllDogs();

    @Query("SELECT * FROM Dog WHERE id = :id")
    Dog findDogById(int id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertDog(List<Dog> dogs);

}
