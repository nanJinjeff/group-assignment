package com.example.groupassignment;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity
public class DogImage {

    String url;

    public String getUrl() {
        return url;
    }

}


