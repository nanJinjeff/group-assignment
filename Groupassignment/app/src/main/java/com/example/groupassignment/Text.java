package com.example.groupassignment;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Text {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String text_topic;
    public String text_content;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setText_content(String text_content) {
        this.text_content = text_content;
    }

    public void setText_topic(String text_topic) {
        this.text_topic = text_topic;
    }

    public String getText_content() {
        return text_content;
    }

    public String getText_topic() {
        return text_topic;
    }

}
