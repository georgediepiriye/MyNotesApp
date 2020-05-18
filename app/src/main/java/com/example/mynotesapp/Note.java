package com.example.mynotesapp;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

//customized Notes class
@Entity(tableName = "note_table")
public class Note {


    //variables for notes class
    @PrimaryKey(autoGenerate = true)
    private  int id;

    @ColumnInfo(name = "user_title")
    private String title;

    @ColumnInfo(name = "user_note")
    private String writtenNote;

    //Constructor for note  class
    public Note(String title, String writtenNote) {
        this.title = title;
        this.writtenNote = writtenNote;
    }


    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }


    public String getWrittenNote() {
        return writtenNote;
    }

    public void setId(int id) {
        this.id = id;
    }



}