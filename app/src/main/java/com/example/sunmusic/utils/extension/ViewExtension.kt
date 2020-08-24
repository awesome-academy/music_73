package com.example.sunmusic.utils.extension

import android.graphics.BitmapFactory
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ImageView
import com.example.sunmusic.R
import com.example.sunmusic.data.executor.AppExecutorImpl
import java.net.URL

fun View.show() {
    visibility = View.VISIBLE
}

fun View.hide() {
    visibility = View.INVISIBLE
}

fun View.gone() {
    visibility = View.GONE
}

fun ImageView.loadImageFromUrl(url: String) {
    AppExecutorImpl.instance.execute {
        val bitmap = try {
            BitmapFactory.decodeStream(URL(url).openConnection().getInputStream())
        } finally {
            BitmapFactory.decodeResource(this.context.resources, R.drawable.ic_launcher_foreground)
        }
        Handler(Looper.getMainLooper()).post { this.setImageBitmap(bitmap) }
    }
}