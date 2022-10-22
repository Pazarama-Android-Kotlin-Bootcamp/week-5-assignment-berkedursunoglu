package com.berkedursunoglu.retrofittutorial.view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.berkedursunoglu.retrofittutorial.data.local.PostEntity
import com.berkedursunoglu.retrofittutorial.data.model.Post
import com.berkedursunoglu.retrofittutorial.data.model.PostDTO
import com.berkedursunoglu.retrofittutorial.repository.PostRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class SecondFragmentViewModel @Inject constructor(
    private val postRepository: PostRepository,
) : ViewModel() {


    var postDTO = MutableLiveData<List<PostDTO>?>()

    fun getPosts() {
        postRepository.getPosts().enqueue(object : Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        val updatePostData = it.map { safePost ->
                            PostDTO(
                                id = safePost.id,
                                title = safePost.title,
                                body = safePost.body,
                                userId = safePost.userId,
                                isFavorite = isExists(safePost.id)
                            )
                        }
                        postDTO.value = updatePostData
                    }
                }
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }


    private fun isExists(postId: Int?): Boolean {
        postId?.let {
            postRepository.getPostById(it)?.let {
                return true
            }
        }
        return false
    }

    fun onFavoritePost(post: PostDTO) {
        post.id?.let { safePostId ->
            postRepository.getPostById(safePostId)?.let {
                postRepository.deleteFavoritePost(
                    PostEntity(
                        postId = post.id.toString(),
                        postTitle = post.title,
                        postBody = post.body
                    )
                )
            } ?: kotlin.run {
                postRepository.insertFavoritePost(
                    PostEntity(
                        postId = post.id.toString(),
                        postTitle = post.title,
                        postBody = post.body
                    )
                )
            }
        }
    }
}

