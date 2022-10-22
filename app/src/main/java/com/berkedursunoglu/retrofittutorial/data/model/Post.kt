package com.berkedursunoglu.retrofittutorial.data.model

import com.google.gson.annotations.SerializedName

data class Post(
    @SerializedName("userId" ) var userId : Int?,
    @SerializedName("id"     ) var id     : Int?,
    @SerializedName("title"  ) var title  : String?,
    @SerializedName("body"   ) var body   : String?
)

data class PostDTO(
    val body: String?,
    val userId: Int?,
    val id: Int?,
    val title: String?,
    var isFavorite: Boolean = false
)