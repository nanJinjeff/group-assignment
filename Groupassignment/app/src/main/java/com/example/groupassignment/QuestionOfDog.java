package com.example.groupassignment;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class QuestionOfDog {
    @PrimaryKey
    int dogId;
    String dogName;
    String dogImage;

    public String getDogName() {
        return dogName;
    }

    public int getDogId() {
        return dogId;
    }

    public String getDogImage() {
        return dogImage;
    }

    public void setDogName(String dogName) {
        this.dogName = dogName;
    }

    public void setDogId(int dogId) {
        this.dogId = dogId;
    }

    public void setDogImage(String dogImage) {
        this.dogImage = dogImage;
    }
}
