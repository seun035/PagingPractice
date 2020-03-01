package com.liadi.oluwaseun.pagingpractise.remote;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ITodoApiService {
    @GET("todos")
    Call<List<Todo>> getTodos();
}
