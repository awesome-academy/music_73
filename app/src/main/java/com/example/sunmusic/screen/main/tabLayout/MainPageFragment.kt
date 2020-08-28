package com.example.sunmusic.screen.main.tabLayout

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.annotation.IdRes
import androidx.viewpager.widget.ViewPager
import com.example.sunmusic.R
import com.example.sunmusic.screen.main.MainPagerAdapter
import com.example.sunmusic.screen.main.TabMenu
import com.example.sunmusic.screen.main.getTabMenuForMenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.fragment_main_page.*

class MainPageFragment : Fragment(), BottomNavigationView.OnNavigationItemSelectedListener {
    var mainPagerAdapter: MainPagerAdapter? = null
    var bottomNavigationView: BottomNavigationView? = null
    var viewPager: ViewPager? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main_page, container, false)
        bottomNavigationView = view.findViewById(R.id.bottomNavigationView)
        viewPager = view.findViewById(R.id.viewPager)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewPager()
        bottomNavigationView?.setOnNavigationItemSelectedListener(this)
    }

    private fun setupViewPager() {
        mainPagerAdapter = MainPagerAdapter(childFragmentManager).apply {
            setItems(
                mutableListOf(
                    TabMenu.HOME,
                    TabMenu.TRENDING,
                    TabMenu.ALBUM,
                    TabMenu.GENRES
                )
            )
        }
        val defaultScreen = TabMenu.HOME
        scrollToScreen(defaultScreen)
        selectBottomNavigationViewMenuItem(defaultScreen.menuItemId)
        viewPager?.adapter = mainPagerAdapter
        viewPager?.addOnPageChangeListener(object : ViewPager.SimpleOnPageChangeListener() {
            override fun onPageSelected(position: Int) {
                val selectedPage = mainPagerAdapter?.getItems()?.get(position)
                if (selectedPage != null) {
                    selectBottomNavigationViewMenuItem(selectedPage.menuItemId)
                }
            }
        })
    }

    private fun selectBottomNavigationViewMenuItem(@IdRes menuItemId: Int) {
        bottomNavigationView?.apply {
            setOnNavigationItemSelectedListener(null)
            selectedItemId = menuItemId
            setOnNavigationItemSelectedListener(this@MainPageFragment)
        }
    }

    private fun scrollToScreen(tabMenu: TabMenu) {
        val screenPosition = mainPagerAdapter?.getItems()?.indexOf(tabMenu)
        if (screenPosition != viewPager!!.currentItem) {
            viewPager!!.currentItem = screenPosition!!
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean =
        getTabMenuForMenuItem(item.itemId)?.let {
            scrollToScreen(it)
            true
        } ?: false
}
