package com.berkedursunoglu.retrofittutorial.repository

import com.berkedursunoglu.retrofittutorial.data.model.Users
import retrofit2.Call

interface UserRepository {

    fun getUsers(): Call<List<Users>>

}