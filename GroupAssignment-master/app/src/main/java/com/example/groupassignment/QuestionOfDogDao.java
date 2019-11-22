package com.example.groupassignment;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

//this interface is to illustrate how to operate the database.
@Dao
public interface QuestionOfDogDao {

    @Query("SELECT * FROM QuestionOfDog ORDER BY random() Limit 10")
    List<QuestionOfDog> getAllQuestionOfDog();

    @Query("UPDATE QuestionOfDog SET dogImage = :imageUrl WHERE dogId = :dogId")
    void setDodImage(String imageUrl, int dogId);

    @Query("SELECT dogImage FROM questionofdog WHERE dogId =:dogId")
    String getDogImage(int dogId);

    @Query("SELECT dogName FROM questionofdog WHERE dogId =:dogId")
    String getDogNmae(int dogId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertQuestionOfDog(QuestionOfDog questionOfDog);
}
