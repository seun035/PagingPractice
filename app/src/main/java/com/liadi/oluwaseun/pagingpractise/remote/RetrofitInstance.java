package com.liadi.oluwaseun.pagingpractise.remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    private static Retrofit retrofitInstance;

    private RetrofitInstance() {}

    public static ITodoApiService  getRetrofitInstanceService() {
        if (retrofitInstance == null){
            retrofitInstance = new Retrofit.Builder()
                    .baseUrl(NetworkUtils.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofitInstance.create(ITodoApiService.class);
    }
}
