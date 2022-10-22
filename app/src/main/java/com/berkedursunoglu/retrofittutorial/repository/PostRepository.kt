package com.berkedursunoglu.retrofittutorial.repository

import com.berkedursunoglu.retrofittutorial.data.local.PostEntity
import com.berkedursunoglu.retrofittutorial.data.model.Post
import com.berkedursunoglu.retrofittutorial.data.model.Users
import dagger.Provides
import retrofit2.Call

interface PostRepository {
     fun getPosts(): Call<List<Post>>
     fun getPostById(id: Int): PostEntity?
     fun insertFavoritePost(post: PostEntity)
     fun deleteFavoritePost(post: PostEntity)
     fun getFavPost(): List<PostEntity>
}