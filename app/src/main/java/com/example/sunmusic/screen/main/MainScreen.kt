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

enum class MainScreen(
    @IdRes val menuItemId: Int,
    @DrawableRes val menuItemIconId: Int,
    @StringRes val titleStringId: Int,
    val fragment: Fragment
) {
    HOME(
        R.id.bottom_home,
        R.drawable.ic_home,
        R.string.home,
        HomeFragment()
    ),
    TRENDING(
        R.id.bottom_trending,
        R.drawable.ic_trending,
        R.string.trending,
        TrendingFragment()
    ),
    ALBUM(
        R.id.bottom_album,
        R.drawable.ic_album,
        R.string.album,
        AlbumFragment()
    ),
    GENRES(
        R.id.bottom_genres,
        R.drawable.ic_genres,
        R.string.genres,
        GenresFragment()
    )
}

fun getMainScreenForMenuItem(menuItemId: Int): MainScreen? {
    for (mainScreen in MainScreen.values()) {
        if (mainScreen.menuItemId == menuItemId) {
            return mainScreen
        }
    }
    return null
}
