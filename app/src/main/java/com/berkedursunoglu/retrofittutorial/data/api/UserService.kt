package com.berkedursunoglu.retrofittutorial.data.api

import com.berkedursunoglu.retrofittutorial.data.model.Users
import retrofit2.http.GET

interface UserService {

    @GET("users")
    fun getUsers(): retrofit2.Call<List<Users>>

}