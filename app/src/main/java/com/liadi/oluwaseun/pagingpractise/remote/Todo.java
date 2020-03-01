package com.liadi.oluwaseun.pagingpractise.remote;

import com.google.gson.annotations.SerializedName;

public class Todo {
    @SerializedName("userId")
    int userId;

    @SerializedName("id")
    int id;

    @SerializedName("title")
    String title;

    @SerializedName("completed")
    boolean completed;

    
    @Override
    public String toString() {
        return "Todo{" +
                "userId=" + userId +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                '}';
    }
}
