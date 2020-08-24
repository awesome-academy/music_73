package com.example.sunmusic.data.source.remote.configapi

import org.json.JSONObject

interface JsonParser {
    fun formJson(jsonObject: JSONObject)
    fun toJson(): JSONObject
}
