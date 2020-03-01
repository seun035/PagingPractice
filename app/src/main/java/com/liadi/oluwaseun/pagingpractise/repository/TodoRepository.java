package com.liadi.oluwaseun.pagingpractise.repository;

import android.content.Context;

import androidx.paging.DataSource;

import com.liadi.oluwaseun.pagingpractise.database.Todo;
import com.liadi.oluwaseun.pagingpractise.database.TodoDatabase;
import com.liadi.oluwaseun.pagingpractise.remote.ITodoApiService;
import com.liadi.oluwaseun.pagingpractise.remote.RetrofitInstance;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import retrofit2.Response;

public class TodoRepository {

    private static TodoRepository repositoryInstance;
    private static TodoDatabase todoDatabase;

    public DataSource.Factory<Integer, Todo> getAllTodo(){
        return todoDatabase.todoDao().getAllTodo();
    }

    public void insertTodo(final Todo todo) {
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(new Runnable() {
            @Override
            public void run() {
                todoDatabase.todoDao().insertTodo(todo);
            }
        });

    }

    public static TodoRepository getRepository(Context context){
        if (repositoryInstance == null){
            todoDatabase = TodoDatabase.getDatabase(context);
            repositoryInstance= new TodoRepository();
        }

        return repositoryInstance;
    }

    public List<com.liadi.oluwaseun.pagingpractise.remote.Todo> getTodoFromNetwork(){

        ITodoApiService service = RetrofitInstance.getRetrofitInstanceService();

        List<com.liadi.oluwaseun.pagingpractise.remote.Todo> todos = new ArrayList<>();
        try {
            Response<List<com.liadi.oluwaseun.pagingpractise.remote.Todo>> reponse = service.getTodos().execute();
            if ( reponse.code() == 200){
                todos = reponse.body();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return todos;
    }
}
