package com.bieitoproyect.androidlifeguardapp.dataModel

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bieitoproyect.androidlifeguardapp.R
import com.bieitoproyect.androidlifeguardapp.databinding.ItemContentAltBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

class ContentAdapter (private val contents: List<Content>, private val listener: OnClickListener) :
    RecyclerView.Adapter<ContentAdapter.ViewHolder>(){

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_content_alt, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val content = contents.get(position)
        with(holder){
            setListener(content, position+1)
            binding.tvContentOrder.text = (position + 1).toString()
            binding.tvContentTitle.text = content.shortTitle
            Glide.with(context)
                .load(content.urlShortImg)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .circleCrop()
                .into(binding.imgContent)
        }
    }

    override fun getItemCount(): Int = contents.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val binding = ItemContentAltBinding.bind(view)
        fun setListener(content: Content, position: Int){
            binding.root.setOnClickListener { listener.onClick(content, position) }
        }
    }
}