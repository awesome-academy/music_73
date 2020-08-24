package com.example.sunmusic.utils.extension

import android.util.Log
import com.example.sunmusic.BuildConfig
import com.example.sunmusic.utils.Constant

fun logDebugApp(message: String, throwable: Throwable? = null) {
    Log.d("###${Constant.APP_ID}", message, throwable)
}