package com.berkedursunoglu.retrofittutorial.view

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.berkedursunoglu.retrofittutorial.listener.RemoveClickListener
import com.berkedursunoglu.retrofittutorial.adapter.FavsAdapter
import com.berkedursunoglu.retrofittutorial.data.local.PostEntity
import com.berkedursunoglu.retrofittutorial.databinding.FragmentFavBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavFragment : Fragment(), RemoveClickListener {

    private lateinit var binding:FragmentFavBinding
    private lateinit var viewModel:FavFragmentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentFavBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[FavFragmentViewModel::class.java]
        viewModel.getFavPost()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.postFav.observe(viewLifecycleOwner, Observer {
            binding.favRecyclerView.adapter = FavsAdapter(it,this@FavFragment)
        })

    }

    @SuppressLint("NotifyDataSetChanged")
    override fun removeFavorite(postEntity: PostEntity) {
        viewModel.removeFav(postEntity)
        binding.favRecyclerView.adapter?.notifyDataSetChanged()
        Toast.makeText(requireContext(),"Favorilerden Kaldırıldı.",Toast.LENGTH_LONG).show()
    }

}