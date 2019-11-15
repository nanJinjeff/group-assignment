package com.example.groupassignment;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Dog {

    @PrimaryKey
        int id;
        String name;
        String bred_for;
        String breed_group;
        String life_span;
        String origin;
        String temperament;

    public String getTemperament() {
        return temperament;
    }

    public String getOrigin() {
        return origin;
    }

    public String getLife_span() {
        return life_span;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getBred_for() {
        return bred_for;
    }

    public String getBreed_group() {
        return breed_group;
    }

}
