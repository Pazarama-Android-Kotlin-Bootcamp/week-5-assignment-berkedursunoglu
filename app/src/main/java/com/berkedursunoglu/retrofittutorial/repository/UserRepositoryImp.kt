package com.berkedursunoglu.retrofittutorial.repository

import com.berkedursunoglu.retrofittutorial.data.api.ApiServices
import com.berkedursunoglu.retrofittutorial.data.api.UserService
import com.berkedursunoglu.retrofittutorial.data.local.FavsDatabase
import com.berkedursunoglu.retrofittutorial.data.model.Users
import retrofit2.Call

class UserRepositoryImp constructor(
private val apiService: UserService
) : UserRepository {
    override fun getUsers(): Call<List<Users>> {
        return apiService.getUsers()
    }
}