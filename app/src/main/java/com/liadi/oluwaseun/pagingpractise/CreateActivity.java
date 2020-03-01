package com.liadi.oluwaseun.pagingpractise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.liadi.oluwaseun.pagingpractise.database.Todo;
import com.liadi.oluwaseun.pagingpractise.repository.TodoRepository;

public class CreateActivity extends AppCompatActivity {

    private Button mSaveButton;
    private EditText mTodoEditText;
    private Button mToListButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_todo);

        mSaveButton = findViewById(R.id.save_todo);

        mTodoEditText = findViewById(R.id.todo_text);

        mToListButton = findViewById(R.id.to_list);

        mSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String todoText = mTodoEditText.getText().toString().trim();
                if (!todoText.isEmpty()){
                    TodoRepository.getRepository(CreateActivity.this).insertTodo(new Todo(0, todoText));
                }
            }
        });

        mToListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent listIntent = new Intent(CreateActivity.this, TodoListActivity.class);
                startActivity(listIntent);
            }
        });
    }
}
