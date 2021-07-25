package com.example.submissionjetpackpro.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.submissionjetpackpro.activity.DetailMovieActivity
import com.example.submissionjetpackpro.adapter.FavoriteMoviesAdapter
import com.example.submissionjetpackpro.databinding.FragmentFavoriteMoviesBinding
import com.example.submissionjetpackpro.viewModel.FavoriteMoviesViewModel
import com.example.submissionjetpackpro.viewModel.ViewModelFactory

class FavoriteMoviesFragment : Fragment() {

    private lateinit var binding: FragmentFavoriteMoviesBinding
    private lateinit var favoriteMoviesAdapter: FavoriteMoviesAdapter
    private lateinit var viewModel: FavoriteMoviesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavoriteMoviesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            favoriteMoviesAdapter = FavoriteMoviesAdapter()
            favoriteMoviesAdapter.notifyDataSetChanged()
            favoriteMoviesAdapter.setOnItemClick(object : FavoriteMoviesAdapter.OnItemClickCallback {
                override fun onItemClickCallback(id: String) {
                    val intent = Intent(activity, DetailMovieActivity::class.java)
                    intent.putExtra(DetailMovieActivity.EXTRA_MOVIE, id)
                    startActivity(intent)
                }
            })
            binding.apply {
                rvMovies.layoutManager = LinearLayoutManager(view.context)
                rvMovies.adapter = favoriteMoviesAdapter
                rvMovies.setHasFixedSize(true)
            }
        }

        val viewModelFactory = ViewModelFactory.getInstance(requireActivity())
        viewModel = ViewModelProvider(this, viewModelFactory)[FavoriteMoviesViewModel::class.java]
        viewModel.favoriteMovies().observe(viewLifecycleOwner, {
            if (it != null) {
                favoriteMoviesAdapter.submitList(it)
            }
        })
    }
}