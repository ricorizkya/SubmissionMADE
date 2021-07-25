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
import com.example.submissionjetpackpro.activity.DetailMovieActivity
import com.example.submissionjetpackpro.adapter.MoviesAdapter
import com.example.submissionjetpackpro.databinding.FragmentMoviesBinding
import com.example.submissionjetpackpro.viewModel.MoviesViewModel
import com.example.submissionjetpackpro.viewModel.ViewModelFactory
import com.example.submissionjetpackpro.vo.Status

class MoviesFragment : Fragment() {

    private lateinit var binding: FragmentMoviesBinding
    private lateinit var moviesAdapter: MoviesAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMoviesBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            moviesAdapter = MoviesAdapter()
            moviesAdapter.notifyDataSetChanged()
            moviesAdapter.setOnItemClickCallback(object : MoviesAdapter.OnItemClickCallback {
                override fun onItem(id: String) {
                    val intent = Intent(activity, DetailMovieActivity::class.java)
                    intent.putExtra(DetailMovieActivity.EXTRA_MOVIE, id)
                    startActivity(intent)
                }
            })
            binding.apply {
                rvMovies.layoutManager = LinearLayoutManager(view.context)
                rvMovies.adapter = moviesAdapter
                rvMovies.setHasFixedSize(true)
            }

            val viewModelFactory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, viewModelFactory)[MoviesViewModel::class.java]
            binding.imgLoading.visibility = View.VISIBLE
            binding.progressBar.visibility = View.VISIBLE
            viewModel.getMovies().observe(viewLifecycleOwner, {
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
                                moviesAdapter.setMovies(list)
                            }
                            moviesAdapter.notifyDataSetChanged()
                            binding.rvMovies.visibility = View.VISIBLE
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
//            val viewModel = ViewModelProvider(this, viewModelFactory)[MoviesViewModel::class.java]
//            moviesAdapter = MoviesAdapter()

//            viewModel.getMovies().observe(viewLifecycleOwner,  { movies ->
//                binding.imgLoading.visibility = View.GONE
//                binding.progressBar.visibility = View.GONE
//                moviesAdapter.apply {
//                    setMovies(movies)
//                    notifyDataSetChanged()
//                    setOnItemClickCallback(this@MoviesFragment)
//                }
//            })
//
//            with(binding.rvMovies) {
//                layoutManager = LinearLayoutManager(context)
//                setHasFixedSize(true)
//                adapter = moviesAdapter
//            }
        }
    }

//    override fun onItem(id: String) {
//        val intent = Intent(context, DetailMovieActivity::class.java)
//        intent.putExtra(DetailMovieActivity.EXTRA_MOVIE, id)
//        context?.startActivity(intent)
//    }
}