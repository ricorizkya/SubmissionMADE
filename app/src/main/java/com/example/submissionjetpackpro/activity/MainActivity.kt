package com.example.submissionjetpackpro.activity

import android.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.submissionjetpackpro.R
import com.example.submissionjetpackpro.databinding.ActivityMainBinding
import com.example.submissionjetpackpro.fragment.FavoriteFragment
import com.example.submissionjetpackpro.fragment.MoviesFragment
import com.example.submissionjetpackpro.fragment.TVShowsFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val moviesFragment = MoviesFragment()
        val tvShowsFragment = TVShowsFragment()
        val favoriteFragment = FavoriteFragment()

        makeCurrentFragment(moviesFragment)
        binding.bottomNavigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.movie_menu -> makeCurrentFragment(moviesFragment)
                R.id.tv_menu -> makeCurrentFragment(tvShowsFragment)
                R.id.favorite_menu -> makeCurrentFragment(favoriteFragment)
            }
            true
        }
    }

    private fun makeCurrentFragment(fragment: androidx.fragment.app.Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_content, fragment)
            commit()
        }
    }
}