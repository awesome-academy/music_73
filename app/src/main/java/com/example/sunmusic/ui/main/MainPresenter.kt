package com.example.sunmusic.ui.main

import com.example.sunmusic.data.repository.AlbumRepositoryImpl
import kotlin.random.Random

class MainPresenter(override var view: MainContract.View?) : MainContract.Presenter {
    private val albumRepository = AlbumRepositoryImpl.instance

    override fun getAllAlbum() {
        // repository get all album
        val success = Random.nextBoolean()
        if (success) {
            view?.onGetAlbumSuccess()
        } else {
            view?.onGetAlbumError()
        }
    }
}