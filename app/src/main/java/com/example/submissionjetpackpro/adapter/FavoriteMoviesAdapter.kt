package com.example.submissionjetpackpro.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.submissionjetpackpro.data.local.model.MoviesEntity
import com.example.submissionjetpackpro.databinding.ItemListBinding

class FavoriteMoviesAdapter: PagedListAdapter<MoviesEntity, FavoriteMoviesAdapter.FavoriteMoviesViewHolder>(DIFF) {

    companion object {
        private val DIFF = object : DiffUtil.ItemCallback<MoviesEntity>() {
            override fun areItemsTheSame(oldItem: MoviesEntity, newItem: MoviesEntity): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: MoviesEntity, newItem: MoviesEntity): Boolean {
                return oldItem == newItem
            }
        }
    }

    private var onItemClickCallback: OnItemClickCallback? = null

    inner class FavoriteMoviesViewHolder(private val binding: ItemListBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(moviesEntity: MoviesEntity) {
            with(binding) {
                tvTitle.text = moviesEntity.title
                tvDescription.text = moviesEntity.description
                tvRate.text = moviesEntity.rating
                Glide.with(itemView.context)
                    .load("https://image.tmdb.org/t/p/w500" + moviesEntity.imgPhoto)
                    .into(imgPhoto)
                }
            binding.root.setOnClickListener {
                onItemClickCallback?.onItemClickCallback(moviesEntity.id.toString())
            }
        }
    }

    fun setOnItemClick(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onBindViewHolder(holder: FavoriteMoviesViewHolder, position: Int) {
        val moviesEntity = getItem(position)
        if (moviesEntity != null) {
            holder.bind(moviesEntity)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteMoviesViewHolder {
        val binding = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavoriteMoviesViewHolder(binding)
    }

    interface OnItemClickCallback {
        fun onItemClickCallback(id: String)
    }
}