package com.liadi.oluwaseun.pagingpractise.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class TodoViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private Application mApplication;
    public TodoViewModelFactory(Application application) {
        mApplication = application;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new TodoViewModel(mApplication);
    }
}
