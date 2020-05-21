package com.example.mynotesapp;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface NotesDao {

    //method to  insert note object into database table
    @Insert
    void insertNote(Note note);

    //method to update note object in the database table
    @Update
    void updateNote(Note note);

    //method to delete note object from the database table
    @Delete
    void deleteNote(Note note);

    //method to delete all notes in the database table
    @Query("DELETE FROM note_table")
    void deleteAllNotes();

    //method to get the list of all notes in the  database table
    @Query("SELECT * FROM note_table ORDER BY id DESC")
    LiveData<List<Note>> getAllNotes();
}
