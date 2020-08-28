package com.example.sunmusic.screen.main

import android.os.Bundle
import android.view.MenuItem
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.sunmusic.R
import com.example.sunmusic.screen.main.tabLayout.MainPageFragment
import com.example.sunmusic.utils.addFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlin.collections.indexOf as collectionsIndexOf

class MainActivity : AppCompatActivity(), MainContract.View {
    private lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addFragment(MainPageFragment(), R.id.container)
        presenter = MainPresenter()
        presenter.setView(this)
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }
}
