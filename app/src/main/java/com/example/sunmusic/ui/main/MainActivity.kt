package com.example.sunmusic.ui.main

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.sunmusic.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(R.layout.activity_main), MainContract.View {

    override var presenter: MainContract.Presenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = MainPresenter(this)
        setSupportActionBar(toolbar)
    }

    override fun onDestroy() {
        presenter = null
        super.onDestroy()
    }

    override fun onGetAlbumSuccess() {
        Toast.makeText(this, "success", Toast.LENGTH_SHORT).show()
    }

    override fun onGetAlbumError() {
        Toast.makeText(this, "error", Toast.LENGTH_SHORT).show()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    companion object {
        val TAG = this::class.java.simpleName
        fun getInstance(): MainActivity {
            return MainActivity()
        }
    }
}