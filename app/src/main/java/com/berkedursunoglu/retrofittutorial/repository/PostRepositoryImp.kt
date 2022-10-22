package com.berkedursunoglu.retrofittutorial.repository

import com.berkedursunoglu.retrofittutorial.data.api.ApiServices
import com.berkedursunoglu.retrofittutorial.data.local.FavsDatabase
import com.berkedursunoglu.retrofittutorial.data.local.PostEntity
import com.berkedursunoglu.retrofittutorial.data.model.Post
import com.berkedursunoglu.retrofittutorial.data.model.Users
import retrofit2.Call

class PostRepositoryImp constructor(
    private val apiService: ApiServices,
    private val postsDatabase: FavsDatabase
) : PostRepository {

    override  fun getPosts(): Call<List<Post>> {
        return apiService.getPosts()
    }

    override  fun getPostById(id: Int): PostEntity? {
        return postsDatabase.postDao().getPostById(id.toString())
    }

    override  fun insertFavoritePost(post: PostEntity) {
        return postsDatabase.postDao().insert(post)
    }

    override  fun deleteFavoritePost(post: PostEntity) {
        return postsDatabase.postDao().delete(post)
    }

    override fun getFavPost(): List<PostEntity> {
        return postsDatabase.postDao().getAllPosts()
    }


}
