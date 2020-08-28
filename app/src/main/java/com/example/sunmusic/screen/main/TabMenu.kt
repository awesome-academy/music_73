package com.example.sunmusic.screen.main

import androidx.annotation.DrawableRes
import androidx.annotation.IdRes
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import com.example.sunmusic.R
import com.example.sunmusic.screen.main.album.AlbumFragment
import com.example.sunmusic.screen.main.genres.GenresFragment
import com.example.sunmusic.screen.main.home.HomeFragment
import com.example.sunmusic.screen.main.trending.TrendingFragment

enum class TabMenu(
    @IdRes val menuItemId: Int,
    @DrawableRes val menuItemIconId: Int,
    @StringRes val titleStringId: Int,
    val fragment: Fragment
) {
    HOME(
        R.id.item_home,
        R.drawable.ic_home,
        R.string.home,
        HomeFragment()
    ),
    TRENDING(
        R.id.item_trending,
        R.drawable.ic_trending,
        R.string.trending,
        TrendingFragment()
    ),
    ALBUM(
        R.id.item_album,
        R.drawable.ic_album,
        R.string.album,
        AlbumFragment()
    ),
    GENRES(
        R.id.item_genres,
        R.drawable.ic_genres,
        R.string.genres,
        GenresFragment()
    )
}

fun getTabMenuForMenuItem(menuItemId: Int): TabMenu? {
    for (tabMenu in TabMenu.values()) {
        if (tabMenu.menuItemId == menuItemId) {
            return tabMenu
        }
    }
    return null
}
