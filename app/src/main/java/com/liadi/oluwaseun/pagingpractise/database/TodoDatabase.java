package com.liadi.oluwaseun.pagingpractise.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Todo.class}, version = 1)
public abstract class TodoDatabase extends RoomDatabase {

    public abstract TodoDao todoDao();

    private static volatile TodoDatabase INSTANCE;

    public static TodoDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (TodoDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            TodoDatabase.class, "todo_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
