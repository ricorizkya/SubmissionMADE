package com.example.submissionjetpackpro.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.submissionjetpackpro.data.local.model.TVShowsEntity
import com.example.submissionjetpackpro.databinding.ItemListBinding
import com.example.submissionjetpackpro.vo.Resources

class TVShowsAdapter: RecyclerView.Adapter<TVShowsAdapter.TVShowViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback
    private var listTVShow = ArrayList<TVShowsEntity>()

    inner class TVShowViewHolder(private val binding: ItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShows: TVShowsEntity) {
            with(binding) {
                tvTitle.text = tvShows.title
                tvDescription.text = tvShows.description
                tvRate.text = tvShows.rating
                Glide.with(itemView)
                    .load("https://image.tmdb.org/t/p/w500" + tvShows.imgPhoto)
                    .into(imgPhoto)
                itemView.setOnClickListener {
                    onItemClickCallback.onItem(tvShows.id.toString())
                }
            }
        }
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    fun setTVShows(tvShows: List<TVShowsEntity>) {
        if (tvShows == null) return
        this.listTVShow.clear()
        this.listTVShow.addAll(tvShows)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TVShowViewHolder {
        val itemListBinding =
            ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TVShowViewHolder(itemListBinding)
    }

    override fun onBindViewHolder(holder: TVShowViewHolder, position: Int) {
        val tvShow = listTVShow[position]
        holder.bind(tvShow)
    }

    override fun getItemCount(): Int = listTVShow.size

    interface OnItemClickCallback {
        fun onItem(id: String)
    }
}