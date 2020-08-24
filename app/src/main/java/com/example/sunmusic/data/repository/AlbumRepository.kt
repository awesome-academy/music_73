package com.example.sunmusic.data.repository

import com.example.sunmusic.data.source.remote.ApiService
import com.example.sunmusic.data.source.remote.ApiServiceImpl
import com.example.sunmusic.domain.repository.AlbumRepository
import kotlin.LazyThreadSafetyMode.NONE

class AlbumRepositoryImpl private constructor(private val api: ApiService) : AlbumRepository {
    companion object {
        val instance by lazy(NONE) { AlbumRepositoryImpl(ApiServiceImpl.instance) }
    }

    override fun getAlbums() {
        // TODO
    }
}