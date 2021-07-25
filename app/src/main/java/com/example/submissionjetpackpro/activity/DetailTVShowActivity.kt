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
import com.example.submissionjetpackpro.data.local.model.TVShowsEntity
import com.example.submissionjetpackpro.databinding.ActivityDetailTVShowBinding
import com.example.submissionjetpackpro.viewModel.DetailTVShowsViewModel
import com.example.submissionjetpackpro.viewModel.ViewModelFactory
import com.example.submissionjetpackpro.vo.Resources
import com.example.submissionjetpackpro.vo.Status

class DetailTVShowActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_TV_SHOW = "extra_tv_show"
    }

    private lateinit var binding: ActivityDetailTVShowBinding
    private lateinit var viewModel: DetailTVShowsViewModel
    private var menu: Menu? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailTVShowBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val viewModelFactory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, viewModelFactory)[DetailTVShowsViewModel::class.java]
        setDetailTVShows()
        viewModel.getTVShowsDetail.observe(this, {
            if (it != null) {
                when (it.status) {
                    Status.SUCCESS -> if (it.data != null) {
                        populateTVShows(it)
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
        viewModel.getTVShowsDetail.observe(this, {
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
                val tvShowsTitle = viewModel.getTVShowsDetail.value?.data?.title
                val url = "https://www.themoviedb.org"
                ShareCompat.IntentBuilder
                    .from(this)
                    .setType(mimeType)
                    .setChooserTitle("Share This Film")
                    .setText("$tvShowsTitle, Check $url for more detail")
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

    private fun populateTVShows(tvShows: Resources<TVShowsEntity>) {
        binding.tvShowTitle.text = tvShows.data?.title
        binding.tvShowDescription.text = tvShows.data?.description
        binding.tvShowRate.text = tvShows.data?.rating
        binding.tvShowRelease.text = tvShows.data?.timeRelease
        Glide.with(this)
                .load("https://image.tmdb.org/t/p/w500" + tvShows.data?.imgPhoto)
                .into(binding.imgPoster)
        supportActionBar?.title = tvShows.data?.title
    }

    private fun setDetailTVShows() {
        val tvShowsId = intent.getStringExtra(EXTRA_TV_SHOW)?.toInt()
        val viewModelFactory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, viewModelFactory)[DetailTVShowsViewModel::class.java]
        if (tvShowsId != null) {
            viewModel.setTVShowsDetail(tvShowsId)
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