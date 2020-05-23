package com.example.mynotesapp;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class CustomNoteViewModelFactory implements ViewModelProvider.Factory {

    private Application mApplication;

    public CustomNoteViewModelFactory(Application mApplication) {
        this.mApplication = mApplication;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new NoteViewModel(mApplication);
    }
}
