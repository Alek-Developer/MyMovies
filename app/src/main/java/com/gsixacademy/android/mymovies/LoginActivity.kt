package com.gsixacademy.android.mymovies

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gsixacademy.android.mymovies.home.ExploreActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        button_login.setOnClickListener {
            startActivity(Intent(applicationContext, ExploreActivity::class.java))
        }

    }
}



