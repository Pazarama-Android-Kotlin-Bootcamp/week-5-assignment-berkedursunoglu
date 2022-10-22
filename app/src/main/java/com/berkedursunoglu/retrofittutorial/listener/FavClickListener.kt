package com.berkedursunoglu.retrofittutorial.listener

import com.berkedursunoglu.retrofittutorial.data.model.Post
import com.berkedursunoglu.retrofittutorial.data.model.PostDTO

interface FavClickListener {

    fun onClick(post: PostDTO)

}