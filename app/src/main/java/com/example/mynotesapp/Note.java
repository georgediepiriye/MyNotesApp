package com.example.mynotesapp;
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

    @ColumnInfo(name = "user_description")
    private String description;


    @ColumnInfo(name = "user_date")
    private String date;

    //Constructor for note  class
    public Note(String title, String description, String date) {
        this.title = title;
        this.description = description;
        this.date = date;
    }


    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }


    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public void setId(int id) {
        this.id = id;
    }



}