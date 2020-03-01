package com.liadi.oluwaseun.pagingpractise;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.liadi.oluwaseun.pagingpractise.adapter.TodoAdapter;
import com.liadi.oluwaseun.pagingpractise.remote.Todo;
import com.liadi.oluwaseun.pagingpractise.viewmodels.TodoViewModel;
import com.liadi.oluwaseun.pagingpractise.viewmodels.TodoViewModelFactory;

import java.util.List;

public class TodoListActivity extends AppCompatActivity {

    TodoViewModel todoViewModel;
    RecyclerView mTodoRecyclerView;
    TodoAdapter mTodoAdapter;
    private static final String TAG = "TodoListActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_list);

        mTodoRecyclerView = findViewById(R.id.recycler);
        todoViewModel = new ViewModelProvider(this, new TodoViewModelFactory(getApplication())).get(TodoViewModel.class);

        todoViewModel.getNetworkTodoData();

        todoViewModel.getTestNetWork().observe(this, new Observer<List<Todo>>() {
            @Override
            public void onChanged(List<Todo> todos) {
                Log.i(TAG, "onChanged: " + todos);
            }
        });

//        mTodoAdapter =  new TodoAdapter();
//        mTodoRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//        todoViewModel.getTodos().observe(this, new Observer<PagedList<Todo>>() {
//            @Override
//            public void onChanged(PagedList<Todo> todos) {
//                if ( todos != null){
//                    Log.i(TAG, "onChanged: "+ todos.toString());
//                    mTodoAdapter.submitList(todos);
//                }
//            }
//        });
//
//        mTodoRecyclerView.setAdapter(mTodoAdapter);
    }
}
