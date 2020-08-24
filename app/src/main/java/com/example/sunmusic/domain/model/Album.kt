package com.example.sunmusic.domain.model

import com.example.sunmusic.data.source.remote.configapi.JsonParser
import org.json.JSONObject

data class Album(var id: String) : JsonParser {
    override fun formJson(jsonObject: JSONObject) {
        id = jsonObject.get("id").toString()
    }

    override fun toJson(): JSONObject {
        return JSONObject()
    }
}