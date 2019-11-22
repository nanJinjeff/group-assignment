package com.example.groupassignment;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;



import java.util.List;

//the interface is used to query and insert the data from and into the room database.
@Dao
public interface DogDao {

    @Query("SELECT * FROM Dog")
    List<Dog> getAllDogs();

    @Query("SELECT * FROM Dog WHERE id = :id")
    Dog findDogById(int id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertDog(List<Dog> dogs);

}
