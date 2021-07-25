package com.example.submissionjetpackpro.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.submissionjetpackpro.activity.DetailTVShowActivity
import com.example.submissionjetpackpro.adapter.TVShowsAdapter
import com.example.submissionjetpackpro.databinding.FragmentTVShowsBinding
import com.example.submissionjetpackpro.viewModel.TVShowsViewModel
import com.example.submissionjetpackpro.viewModel.ViewModelFactory
import com.example.submissionjetpackpro.vo.Status

class TVShowsFragment : Fragment() {

    private lateinit var binding: FragmentTVShowsBinding
    private lateinit var tvShowsAdapter: TVShowsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTVShowsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            tvShowsAdapter = TVShowsAdapter()
            tvShowsAdapter.notifyDataSetChanged()
            tvShowsAdapter.setOnItemClickCallback(object : TVShowsAdapter.OnItemClickCallback {
                override fun onItem(id: String) {
                    val intent = Intent(context, DetailTVShowActivity::class.java)
                    intent.putExtra(DetailTVShowActivity.EXTRA_TV_SHOW, id)
                    context?.startActivity(intent)
                }
            })
            binding.apply {
                rvTvShows.layoutManager = LinearLayoutManager(view.context)
                rvTvShows.adapter = tvShowsAdapter
                rvTvShows.setHasFixedSize(true)
            }

            val viewModelFactory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, viewModelFactory)[TVShowsViewModel::class.java]
            binding.imgLoading.visibility = View.VISIBLE
            binding.progressBar.visibility = View.VISIBLE
            viewModel.getTVShows().observe(viewLifecycleOwner, {
                if (it != null) {
                    when (it.status) {
                        Status.LOADING -> {
                            binding.imgLoading.visibility = View.VISIBLE
                            binding.progressBar.visibility = View.VISIBLE
                        }
                        Status.SUCCESS -> {
                            binding.imgLoading.visibility = View.GONE
                            binding.progressBar.visibility = View.GONE
                            it.data?.let { list ->
                                tvShowsAdapter.setTVShows(list)
                            }
                            tvShowsAdapter.notifyDataSetChanged()
                            binding.rvTvShows.visibility = View.VISIBLE
                        }
                        Status.ERROR -> {
                            binding.imgLoading.visibility = View.VISIBLE
                            binding.progressBar.visibility = View.VISIBLE
                            Toast.makeText(context, "Load Data Failed", Toast.LENGTH_LONG).show()
                        }
                    }
                }
            })
//            val viewModelFactory = ViewModelFactory.getInstance(requireActivity())
//            val viewModel = ViewModelProvider(this, viewModelFactory)[TVShowsViewModel::class.java]
//            tvShowsAdapter = TVShowsAdapter()
//
//            viewModel.getTVShows().observe(viewLifecycleOwner, { tvShows ->
//                binding.imgLoading.visibility = View.GONE
//                binding.progressBar.visibility = View.GONE
//                tvShowsAdapter.apply {
//                    setTVShows(tvShows)
//                    notifyDataSetChanged()
//                    setOnItemClickCallback(this@TVShowsFragment)
//                }
//            })
//
//            with(binding.rvTvShows) {
//                layoutManager = LinearLayoutManager(context)
//                setHasFixedSize(true)
//                adapter = tvShowsAdapter
//            }
        }
    }

//    override fun onItem(id: String) {
//        val intent = Intent(context, DetailTVShowActivity::class.java)
//        intent.putExtra(DetailTVShowActivity.EXTRA_TV_SHOW, id)
//        context?.startActivity(intent)
//    }
}