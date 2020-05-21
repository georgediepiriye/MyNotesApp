package com.example.mynotesapp;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class NoteRepository {

    private NotesDao notesDao;
    private LiveData<List<Note>> allNotes;

    /**
     * Constructor for repository
     */
    public NoteRepository(Application application) {

        //database instance
        NoteDatabase database = NoteDatabase.getInstance(application);
        notesDao = database.notesDao();
        allNotes = notesDao.getAllNotes();
    }

    /**
     * methods to carry out various database operations
     */
    public void insert(Note note) {
        new InsertNoteAsyncTask(notesDao).execute(note);
    }

    public void update(Note note) {
        new UpdateNoteAsyncTask(notesDao).execute(note);

    }

    public void delete(Note note) {
        new DeleteNoteAsyncTask(notesDao).execute(note);
    }

    public void deleteAllNotes() {
        new DeleteAllNoteAsyncTask(notesDao).execute();
    }

    public LiveData<List<Note>> getAllNotes() {
        return allNotes;
    }


    //Insert operation to be carried out in background thread
    private static class InsertNoteAsyncTask extends AsyncTask<Note, Void, Void> {
        private NotesDao noteDao;

        private InsertNoteAsyncTask(NotesDao notesDao) {
            this.noteDao = notesDao;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.insertNote(notes[0]);
            return null;
        }
    }


    //update operation to be carried out in background thread
    private static class UpdateNoteAsyncTask extends AsyncTask<Note, Void, Void> {
        private NotesDao noteDao;

        private UpdateNoteAsyncTask(NotesDao notesDao) {
            this.noteDao = notesDao;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.updateNote(notes[0]);
            return null;
        }
    }

    //Delete operation to be carried out in background thread
    private static class DeleteNoteAsyncTask extends AsyncTask<Note, Void, Void> {
        private NotesDao noteDao;

        private DeleteNoteAsyncTask(NotesDao notesDao) {
            this.noteDao = notesDao;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.deleteNote(notes[0]);
            return null;
        }
    }


    //Delete all notes operation to be carried out in background thread
    private static class DeleteAllNoteAsyncTask extends AsyncTask<Void, Void, Void> {
        private NotesDao noteDao;

        private DeleteAllNoteAsyncTask(NotesDao notesDao) {
            this.noteDao = notesDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            noteDao.deleteAllNotes();
            return null;
        }
    }
}