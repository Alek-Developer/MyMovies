package com.gsixacademy.android.mymovies.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gsixacademy.android.mymovies.R
import kotlinx.android.synthetic.main.activity_explore.*

class ExploreActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_explore)


        val adapter = ExploreMoviesPagerAdapter(supportFragmentManager)
        view_pager_movies.adapter = adapter
        tab_layout_movies.setupWithViewPager(view_pager_movies)


        }
    }

