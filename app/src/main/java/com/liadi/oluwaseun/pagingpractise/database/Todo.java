package com.liadi.oluwaseun.pagingpractise.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "todo_table")
public class Todo {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "item")
    private String item;

    public Todo(int id, String item) {
        this.id = id;
        this.item = item;
    }

    public int getId() {
        return id;
    }

    public String getItem() {
        return item;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", item='" + item + '\'' +
                '}';
    }
}
