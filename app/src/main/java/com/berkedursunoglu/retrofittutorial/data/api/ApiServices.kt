package com.berkedursunoglu.retrofittutorial.data.api

import com.berkedursunoglu.retrofittutorial.data.model.Post
import com.berkedursunoglu.retrofittutorial.data.model.Users
import retrofit2.Call
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiServices {

    @GET("posts")
    fun getPosts(): retrofit2.Call<List<Post>>

    @GET("users")
    fun getUsers(): retrofit2.Call<List<Users>>

    @DELETE("posts/{id}")
    fun deletePost(@Path("{id}}") id:String): retrofit2.Call<Post>

}