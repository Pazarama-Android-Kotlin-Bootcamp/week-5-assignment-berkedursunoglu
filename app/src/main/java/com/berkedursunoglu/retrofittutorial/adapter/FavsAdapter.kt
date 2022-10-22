package com.berkedursunoglu.retrofittutorial.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.berkedursunoglu.retrofittutorial.R
import com.berkedursunoglu.retrofittutorial.data.local.PostEntity
import com.berkedursunoglu.retrofittutorial.databinding.ItemFavLayoutBinding
import com.berkedursunoglu.retrofittutorial.listener.RemoveClickListener

class FavsAdapter(val array:List<PostEntity>,val listener: RemoveClickListener) : RecyclerView.Adapter<PostDaoHolder>() {

    private lateinit var binding: ItemFavLayoutBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostDaoHolder {
        binding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_fav_layout,parent,false)
        return PostDaoHolder(binding)
    }

    override fun onBindViewHolder(holder: PostDaoHolder, position: Int) {
        binding.post = array[position]
        binding.removeFav.setOnClickListener {
            listener.removeFavorite(array[position])
            notifyItemRemoved(position)
        }
    }

    override fun getItemCount(): Int {
        return array.size
    }

}

class PostDaoHolder(binding: ItemFavLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

}
