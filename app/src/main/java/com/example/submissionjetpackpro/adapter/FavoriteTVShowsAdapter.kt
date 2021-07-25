package com.example.submissionjetpackpro.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.submissionjetpackpro.data.local.model.TVShowsEntity
import com.example.submissionjetpackpro.databinding.ItemListBinding

class FavoriteTVShowsAdapter: PagedListAdapter<TVShowsEntity, FavoriteTVShowsAdapter.FavoriteTVShowsViewHolder>(DIFF) {

    companion object {
        private val DIFF = object : DiffUtil.ItemCallback<TVShowsEntity>() {
            override fun areItemsTheSame(oldItem: TVShowsEntity, newItem: TVShowsEntity): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: TVShowsEntity, newItem: TVShowsEntity): Boolean {
                return oldItem == newItem
            }

        }
    }

    private var onItemClickCallback: OnItemClickCallback? = null

    inner class FavoriteTVShowsViewHolder(private val binding: ItemListBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShowsEntity: TVShowsEntity) {
            with(binding) {
                tvTitle.text = tvShowsEntity.title
                tvDescription.text = tvShowsEntity.description
                tvRate.text = tvShowsEntity.rating
                Glide.with(itemView.context)
                    .load("https://image.tmdb.org/t/p/w500" + tvShowsEntity.imgPhoto)
                    .into(imgPhoto)
                itemView.setOnClickListener {
                    onItemClickCallback?.onItemClickCallback(tvShowsEntity.id.toString())
                }
            }
        }
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onBindViewHolder(holder: FavoriteTVShowsViewHolder, position: Int) {
        val tvShows = getItem(position)
        if (tvShows != null) {
            holder.bind(tvShows)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteTVShowsViewHolder {
        val itemListBinding = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavoriteTVShowsViewHolder(itemListBinding)
    }

    interface OnItemClickCallback {
        fun onItemClickCallback(id: String)
    }
}