package com.berkedursunoglu.retrofittutorial.listener

import com.berkedursunoglu.retrofittutorial.data.local.PostEntity

interface RemoveClickListener {
    fun removeFavorite(postEntity: PostEntity)
}