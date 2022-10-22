package com.berkedursunoglu.retrofittutorial.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.berkedursunoglu.retrofittutorial.R
import com.berkedursunoglu.retrofittutorial.adapter.UserAdapter
import com.berkedursunoglu.retrofittutorial.databinding.FragmentFirstBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FirstFragment : Fragment() {

    private lateinit var binding:FragmentFirstBinding
    private lateinit var viewModel:FirstFragmentViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater,container,false)

        viewModel = ViewModelProvider(this)[FirstFragmentViewModel::class.java]

        viewModel.getUsers()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.users.observe(viewLifecycleOwner, Observer {
             binding.userRecyclerView.adapter = UserAdapter(it)
            binding.postProgressBar.visibility = View.GONE
            binding.userRecyclerView.visibility = View.VISIBLE
        })
    }
}