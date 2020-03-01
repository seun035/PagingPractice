package com.liadi.oluwaseun.pagingpractise.database;

import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;


@Dao
public interface TodoDao {

    @Query("SELECT * FROM todo_table")
    DataSource.Factory<Integer, Todo> getAllTodo();

    @Insert
    void insertTodo(Todo todo);
}
