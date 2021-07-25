package com.example.submissionjetpackpro.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.submissionjetpackpro.data.local.model.MoviesEntity
import com.example.submissionjetpackpro.databinding.ItemListBinding
import com.example.submissionjetpackpro.vo.Resources

class MoviesAdapter: RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback
    private var listMovies = ArrayList<MoviesEntity>()

    inner class MovieViewHolder(private val binding: ItemListBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(movies: MoviesEntity) {
            with(binding) {
                tvTitle.text = movies.title
                tvDescription.text = movies.description
                tvRate.text = movies.rating
                Glide.with(itemView.context)
                        .load("https://image.tmdb.org/t/p/w500" + movies.imgPhoto)
                        .into(imgPhoto)
                itemView.setOnClickListener {
                    onItemClickCallback.onItem(movies.id.toString())
                }
            }
        }
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    fun setMovies(movies: List<MoviesEntity>) {
        if (movies == null) return
        this.listMovies.clear()
        this.listMovies.addAll(movies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesAdapter.MovieViewHolder {
        val itemListBinding = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(itemListBinding)
    }

    override fun onBindViewHolder(holder: MoviesAdapter.MovieViewHolder, position: Int) {
        val movie = listMovies[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int = listMovies.size

    interface OnItemClickCallback {
        fun onItem(id: String)
    }
}