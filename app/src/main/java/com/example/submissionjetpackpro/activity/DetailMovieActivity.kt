package com.example.submissionjetpackpro.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.core.app.ShareCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.submissionjetpackpro.R
import com.example.submissionjetpackpro.data.local.model.MoviesEntity
import com.example.submissionjetpackpro.databinding.ActivityDetailMovieBinding
import com.example.submissionjetpackpro.viewModel.DetailMoviesViewModel
import com.example.submissionjetpackpro.viewModel.ViewModelFactory
import com.example.submissionjetpackpro.vo.Resources
import com.example.submissionjetpackpro.vo.Status

class DetailMovieActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
    }

    private lateinit var binding: ActivityDetailMovieBinding
    private lateinit var viewModel: DetailMoviesViewModel
    private var menu: Menu? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val viewModelFactory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, viewModelFactory)[DetailMoviesViewModel::class.java]
        setDetailMovies()
        viewModel.getMoviesDetail.observe(this, {
            if (it != null) {
                when (it.status) {
                    Status.SUCCESS -> if (it.data != null) {
                        populateMovies(it)
                    }
                    Status.ERROR -> {
                        Toast.makeText(this, "Load Data Failed", Toast.LENGTH_LONG).show()
                    }
                }
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.favorite_share, menu)
        this.menu = menu
        viewModel.getMoviesDetail.observe(this, {
            if (it != null) {
                when (it.status) {
                    Status.SUCCESS -> if (it.data != null) {
                        val stateFavorite = it.data.favorite
                        favoriteState(stateFavorite)
                    }
                    Status.ERROR -> {
                        Toast.makeText(this, "Load Data Failed", Toast.LENGTH_LONG).show()
                    }
                }
            }
        })
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.btn_share -> {
                val mimeType = "text/plain"
                val moviesTitle = viewModel.getMoviesDetail.value?.data?.title
                val url = "https://www.themoviedb.org"
                ShareCompat.IntentBuilder
                    .from(this)
                    .setType(mimeType)
                    .setChooserTitle("Share This Film")
                    .setText("$moviesTitle, Check $url for more detail")
                    .startChooser()
                return true
            }
            R.id.btn_fav -> {
                viewModel.setFavorite()
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun populateMovies(movies: Resources<MoviesEntity>?) {
        if (movies != null) {
            binding.tvTitle.text = movies.data?.title
            binding.tvDescription.text = movies.data?.description
            binding.tvRate.text = movies.data?.rating
            binding.tvRelease.text = movies.data?.timeRelease
            Glide.with(this)
                .load("https://image.tmdb.org/t/p/w500" + movies.data?.imgPhoto)
                .into(binding.imgPoster)
            supportActionBar?.title = movies.data?.title
        }
    }

    private fun setDetailMovies() {
        val moviesId = intent.getStringExtra(EXTRA_MOVIE)?.toInt()
        val viewModelFactory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, viewModelFactory)[DetailMoviesViewModel::class.java]
        if (moviesId != null) {
            viewModel.setMoviesDetail(moviesId)
        }
    }

    private fun favoriteState(stateFavorite: Boolean) {
        if (menu == null) return
        if (stateFavorite) {
            menu?.findItem(R.id.btn_fav)?.icon = ContextCompat.getDrawable(this, R.drawable.ic_baseline_favorite_24)
        }else {
            menu?.findItem(R.id.btn_fav)?.icon = ContextCompat.getDrawable(this, R.drawable.ic_baseline_favorite_border_24)
        }
    }

}