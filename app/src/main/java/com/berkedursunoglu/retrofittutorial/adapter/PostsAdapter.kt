package com.berkedursunoglu.retrofittutorial.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.berkedursunoglu.retrofittutorial.listener.FavClickListener
import com.berkedursunoglu.retrofittutorial.R
import com.berkedursunoglu.retrofittutorial.data.model.PostDTO
import com.berkedursunoglu.retrofittutorial.databinding.ItemPostLayoutBinding

class PostsAdapter(val array:List<PostDTO>,val listener: FavClickListener) : RecyclerView.Adapter<ViewHolder>() {

    private val TAG = PostsAdapter::class.java.simpleName

    private lateinit var binding:ItemPostLayoutBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_post_layout,parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder,position: Int) {
        val post = array[position]
        binding.post = array[position]
        binding.favButton.setOnClickListener {
            listener.onClick(post)
            notifyItemInserted(position)
        }
        binding.executePendingBindings()
    }

    override fun getItemCount(): Int {
        return array.size
    }
}

class ViewHolder(binding: ItemPostLayoutBinding) :RecyclerView.ViewHolder(binding.root){

}
