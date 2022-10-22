package com.berkedursunoglu.retrofittutorial.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.berkedursunoglu.retrofittutorial.listener.FavClickListener
import com.berkedursunoglu.retrofittutorial.adapter.PostsAdapter
import com.berkedursunoglu.retrofittutorial.data.model.PostDTO
import com.berkedursunoglu.retrofittutorial.databinding.FragmentSecondBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SecondFragment : Fragment(), FavClickListener {
    private val TAG = "PostsAdapter/ViewModel"

    private lateinit var bindig:FragmentSecondBinding
    private lateinit var viewModel :SecondFragmentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        bindig = FragmentSecondBinding.inflate(inflater,container,false)
        viewModel = ViewModelProvider(this)[SecondFragmentViewModel::class.java]
        viewModel.getPosts()
        return bindig.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.postDTO.observe(viewLifecycleOwner, Observer {
            Log.d(TAG,it.toString())
            it.let {
                bindig.postRecyclerView.adapter = PostsAdapter(it!!,this@SecondFragment)
                bindig.postProgressBar.visibility = View.GONE
                bindig.postRecyclerView.visibility = View.VISIBLE
            }
        })
    }


    override fun onClick(post: PostDTO) {
        viewModel.onFavoritePost(post)
        Toast.makeText(requireContext(),"Favorilere Eklendi.", Toast.LENGTH_LONG).show()
    }


}