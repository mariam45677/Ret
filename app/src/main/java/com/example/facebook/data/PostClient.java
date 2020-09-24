package com.example.facebook.data;

import com.example.facebook.pojo.PostModel;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostClient {
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    private PostApi postApi;
    private static PostClient INSTANCE;

    public PostClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        postApi =retrofit.create(PostApi.class);



    }

    public static PostClient getINSTANCE() {
        if (null == INSTANCE){
        INSTANCE = new PostClient();
    }
        return INSTANCE;
    }
    public Call<List<PostModel>> getPosts(){
        return postApi.getPosts();
    }


}
