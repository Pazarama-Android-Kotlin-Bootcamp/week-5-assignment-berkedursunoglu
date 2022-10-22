package com.berkedursunoglu.retrofittutorial.view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.room.Room
import com.berkedursunoglu.retrofittutorial.data.local.FavsDatabase
import com.berkedursunoglu.retrofittutorial.data.local.PostEntity
import com.berkedursunoglu.retrofittutorial.repository.PostRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavFragmentViewModel @Inject constructor(
    private val postRepository: PostRepository,
): ViewModel() {

    val postFav = MutableLiveData<List<PostEntity>>()

    fun getFavPost(){
        postFav.value = postRepository.getFavPost()
    }

    fun removeFav(post: PostEntity){
        postRepository.deleteFavoritePost(post)
    }

}