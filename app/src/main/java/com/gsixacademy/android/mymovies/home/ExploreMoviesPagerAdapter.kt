package com.gsixacademy.android.mymovies.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class ExploreMoviesPagerAdapter(fragmentManager: FragmentManager) :
    FragmentStatePagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment {

        var fragment: Fragment
        var args = Bundle()

        args.putString("category", getCategory(position))

        fragment = MoviesFragment()
        fragment.arguments = args

        return fragment
    }

    override fun getCount(): Int {
        return 4
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when (position) {
            0 -> return "popular"
            1 -> return "top_rated"
            2 -> return "upcoming"
            3 -> return "now_playing"
        }
        return ""
    }

    fun getCategory(position: Int): String {
        when (position) {
            0 -> return "popular"
            1 -> return "top_rated"
            2 -> return "upcoming"
            3 -> return "now_playing"
        }
        return ""
    }

}
