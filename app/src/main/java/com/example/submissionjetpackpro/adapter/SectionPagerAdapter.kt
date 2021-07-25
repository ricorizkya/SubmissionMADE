package com.example.submissionjetpackpro.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.submissionjetpackpro.fragment.FavoriteMoviesFragment
import com.example.submissionjetpackpro.fragment.FavoriteTVShowsFragment

class SectionPagerAdapter(private val context: Context, fragmentActivity: FragmentActivity)
    :FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = FavoriteMoviesFragment()
            1 -> fragment = FavoriteTVShowsFragment()
        }
        return fragment as Fragment
    }
}