package com.example.sunmusic.ui.main

interface MainContract {
    interface View {
        var presenter: Presenter?
        fun onGetAlbumSuccess()
        fun onGetAlbumError()
    }

    interface Presenter {
        var view: View?
        fun getAllAlbum()
    }
}