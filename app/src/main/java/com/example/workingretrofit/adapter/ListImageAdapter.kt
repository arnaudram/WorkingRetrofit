package com.example.workingretrofit.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.workingretrofit.R
import com.example.workingretrofit.databinding.ItemViewBinding
import com.example.workingretrofit.model.EntityNetwork

class ListImageAdapter:ListAdapter<EntityNetwork,ListImageAdapter.ImageViewHolder>(ImageDiffUtil) {

     companion object ImageDiffUtil:DiffUtil.ItemCallback<EntityNetwork>(){
         override fun areItemsTheSame(oldItem: EntityNetwork, newItem: EntityNetwork): Boolean {
             return oldItem===newItem
         }

         override fun areContentsTheSame(oldItem: EntityNetwork, newItem: EntityNetwork): Boolean {
             return oldItem.id==newItem.id
         }

     }
 class ImageViewHolder(private var binding: ItemViewBinding) : RecyclerView.ViewHolder(binding.root){
     fun bind(entityNetwork: EntityNetwork?) {
         binding.entityNetWork=entityNetwork!!
         binding.executePendingBindings()
     }

 }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val binding=DataBindingUtil.inflate<ItemViewBinding>(LayoutInflater.from(parent.context), R.layout.item_view,parent,false)
        return ImageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val itemView=getItem(position)
        holder.bind(itemView)
    }

}