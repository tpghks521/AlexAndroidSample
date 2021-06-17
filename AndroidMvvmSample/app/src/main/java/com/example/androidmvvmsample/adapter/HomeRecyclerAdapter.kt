package com.example.androidmvvmsample.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.example.androidmvvmsample.data.KakaoImage
import com.example.androidmvvmsample.databinding.ItemRecyclerHomeBinding

class HomeRecyclerAdapter() : PagingDataAdapter<KakaoImage, HomeViewHolder>(HomeDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder(
            ItemRecyclerHomeBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val image = getItem(position)
        image?.let { item ->
            holder.bind(item)
        }
    }
}

private class HomeDiffCallback : DiffUtil.ItemCallback<KakaoImage>() {
    override fun areItemsTheSame(oldItem: KakaoImage, newItem: KakaoImage): Boolean {
        return oldItem.image_url == newItem.image_url
    }

    override fun areContentsTheSame(oldItem: KakaoImage, newItem: KakaoImage): Boolean {
        return oldItem == newItem
    }
}