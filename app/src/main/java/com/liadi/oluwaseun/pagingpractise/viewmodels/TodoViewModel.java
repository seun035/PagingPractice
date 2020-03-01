package com.liadi.oluwaseun.pagingpractise.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.liadi.oluwaseun.pagingpractise.database.Todo;
import com.liadi.oluwaseun.pagingpractise.repository.TodoRepository;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class TodoViewModel extends AndroidViewModel {
    private TodoRepository todoRepository;
    private MutableLiveData<List<com.liadi.oluwaseun.pagingpractise.remote.Todo>> testNetWork = new MutableLiveData<List<com.liadi.oluwaseun.pagingpractise.remote.Todo>>();

    public TodoViewModel(@NonNull Application application) {
        super(application);
        todoRepository = TodoRepository.getRepository(application);
    }

    public LiveData<PagedList<Todo>> getTodos(){
        PagedList.Config pagedListConfig =
                (new PagedList.Config.Builder())
                        .setPageSize(5)
                        .setEnablePlaceholders(false)
                        .setInitialLoadSizeHint(5)
                        .build();
        return new LivePagedListBuilder<>(todoRepository.getAllTodo(), pagedListConfig).build();
    }

    public void getNetworkTodoData() {
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(new Runnable() {
            @Override
            public void run() {
                List<com.liadi.oluwaseun.pagingpractise.remote.Todo> todos = todoRepository.getTodoFromNetwork();
                testNetWork.postValue(todos);
            }
        });
    }

    public LiveData<List<com.liadi.oluwaseun.pagingpractise.remote.Todo>> getTestNetWork() {
        return  testNetWork;
    }
}
