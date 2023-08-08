package com.example.fetchdata.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.fetchdata.R
import com.example.fetchdata.databinding.PostItemBinding
import com.example.fetchdata.models.PostResponseItem

class PostAdapter() : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    val postList =  ArrayList<PostResponseItem>()
    private var click: onPlaceClick? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {

        val layInflater = LayoutInflater.from(parent.context)
        val binding: PostItemBinding = DataBindingUtil.inflate(layInflater, R.layout.post_item, parent, false)
        return PostViewHolder(binding)
    }


    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    inner class PostViewHolder(val binding: PostItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(position: Int) {
            val result = postList[position]
            binding.model = result

            binding.tvPost.setOnClickListener {
                click?.onClick(position)
            }
        }
    }

    fun updateList(list:ArrayList<PostResponseItem>)
    {
        postList.clear()
        postList.addAll(list)
        notifyDataSetChanged()
    }

    interface onPlaceClick {
        fun onClick(position: Int)
    }

    fun setClickListener(onPlaceClick: onPlaceClick) {
        click = onPlaceClick
    }
}