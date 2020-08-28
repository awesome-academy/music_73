package com.example.sunmusic.screen.main

import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class MainPagerAdapter(fragmentManager: FragmentManager) :
    FragmentStatePagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val fragments = mutableListOf<TabMenu>()

    fun setItems(tabMenu: MutableList<TabMenu>) {
        this.fragments.apply {
            addAll(tabMenu)
            notifyDataSetChanged()
        }
    }

    fun getItems() = fragments

    override fun getItem(position: Int) = fragments[position].fragment

    override fun getCount() = fragments.size
}
