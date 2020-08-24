package com.example.sunmusic.data.source.remote

import android.util.Log
import com.example.sunmusic.BuildConfig
import com.example.sunmusic.data.source.remote.configapi.JsonParser
import com.example.sunmusic.utils.Constant
import com.example.sunmusic.utils.extension.toObject
import org.json.JSONException
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import kotlin.LazyThreadSafetyMode.SYNCHRONIZED

interface ApiService {
    fun <T : JsonParser> get(query: String, clazz: Class<T>): List<T>
}

class ApiServiceImpl private constructor(private val baseUrl: String) : ApiService {

    companion object {
        val instance by lazy(SYNCHRONIZED) { ApiServiceImpl(BuildConfig.BASE_URL) }
    }

    override fun <T : JsonParser> get(query: String, clazz: Class<T>): List<T> {
        val url = URL("$baseUrl$query")
        val urlConnection = url.openConnection() as HttpURLConnection
        if (urlConnection.responseCode == HttpURLConnection.HTTP_OK) {
            val json = InputStreamReader(urlConnection.inputStream).readText()
            try {
                return json.toObject(clazz)
            } catch (e: JSONException) {
                if (BuildConfig.DEBUG) {
                    Log.e(Constant.APP_ID, e.message.toString())
                    Log.d("###{${Constant.APP_ID}", e.message.toString())
                }
            }
        }
        return emptyList()
    }
}