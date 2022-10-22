package com.berkedursunoglu.retrofittutorial.adapter
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.berkedursunoglu.retrofittutorial.R
import com.berkedursunoglu.retrofittutorial.data.model.Users
import com.berkedursunoglu.retrofittutorial.databinding.ItemUserLayoutBinding

class UserAdapter(val array:List<Users>) : RecyclerView.Adapter<ViewHolderUser>() {

    private lateinit var binding: ItemUserLayoutBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderUser {
        binding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_user_layout,parent,false)
        return ViewHolderUser(binding)
    }

    override fun getItemCount(): Int {
        return array.size
    }

    override fun onBindViewHolder(holder: ViewHolderUser, position: Int) {
        binding.tvUserName.text = array[position].username
        binding.tvName.text = array[position].name
        binding.tvPhone.text = array[position].phone
    }

}

class ViewHolderUser(binding: ItemUserLayoutBinding):RecyclerView.ViewHolder(binding.root){

}



