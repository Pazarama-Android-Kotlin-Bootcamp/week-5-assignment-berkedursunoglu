package com.berkedursunoglu.retrofittutorial.view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.berkedursunoglu.retrofittutorial.data.model.Users
import com.berkedursunoglu.retrofittutorial.repository.PostRepository
import com.berkedursunoglu.retrofittutorial.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class FirstFragmentViewModel @Inject constructor(
    private val postRepository: UserRepository,
)  : ViewModel() {

    val users = MutableLiveData<List<Users>>()

    fun getUsers() {
        postRepository.getUsers().enqueue(object : Callback<List<Users>> {
            override fun onResponse(call: Call<List<Users>>, response: Response<List<Users>>) {
                if (response.isSuccessful) {
                    if (response.body() !=  null){
                        users.value = response.body()
                    }
                }

            }

            override fun onFailure(call: Call<List<Users>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }


}