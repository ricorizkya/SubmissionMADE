package com.example.submissionjetpackpro.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.submissionjetpackpro.R
import com.example.submissionjetpackpro.activity.DetailTVShowActivity
import com.example.submissionjetpackpro.adapter.FavoriteTVShowsAdapter
import com.example.submissionjetpackpro.data.local.model.TVShowsEntity
import com.example.submissionjetpackpro.databinding.FragmentFavoriteTVShowsBinding
import com.example.submissionjetpackpro.viewModel.FavoriteTVShowsViewModel
import com.example.submissionjetpackpro.viewModel.ViewModelFactory

class FavoriteTVShowsFragment : Fragment() {

    private lateinit var binding: FragmentFavoriteTVShowsBinding
    private lateinit var tvShowsAdapter: FavoriteTVShowsAdapter
    private lateinit var viewModel: FavoriteTVShowsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavoriteTVShowsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            tvShowsAdapter = FavoriteTVShowsAdapter()
            tvShowsAdapter.notifyDataSetChanged()
            tvShowsAdapter.setOnItemClickCallback(object : FavoriteTVShowsAdapter.OnItemClickCallback {
                override fun onItemClickCallback(id: String) {
                    val intent = Intent(activity, DetailTVShowActivity::class.java)
                    intent.putExtra(DetailTVShowActivity.EXTRA_TV_SHOW, id)
                    startActivity(intent)
                }
            })
            binding.apply {
                rvTvShows.layoutManager = LinearLayoutManager(view.context)
                rvTvShows.adapter = tvShowsAdapter
                rvTvShows.setHasFixedSize(true)
            }
        }

        val viewModelFactory = ViewModelFactory.getInstance(requireActivity())
        viewModel = ViewModelProvider(this, viewModelFactory)[FavoriteTVShowsViewModel::class.java]
        viewModel.favoriteTVShows().observe(viewLifecycleOwner, {
            if (it != null) {
                tvShowsAdapter.submitList(it)
            }
        })
    }
}