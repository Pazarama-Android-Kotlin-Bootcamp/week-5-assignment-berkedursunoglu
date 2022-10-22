package com.berkedursunoglu.retrofittutorial.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.berkedursunoglu.retrofittutorial.data.model.Post

@Dao
interface FavDAO:BaseDao<PostEntity> {

    @Query("SELECT * FROM favs")
    fun getAllPosts(): List<PostEntity>

    @Query("DELETE FROM favs")
    fun deleteAll()

    @Query("SELECT * FROM favs WHERE postId = :postId")
    fun getPostById(postId: String): PostEntity?

}