package com.example.taptalkuisampleapp

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import io.taptalk.TapTalk.Helper.TapTalk
import io.taptalk.TapTalk.Manager.TAPDataManager
import io.taptalk.TapTalk.Manager.TapUI


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (TAPDataManager.getInstance().checkAccessTokenAvailable()!!) {
            TapUI.getInstance().openRoomList(this)
        } else {
            val intent = Intent(this@MainActivity, TAPLoginActivity::class.java)
            startActivity(intent)
        }
        finish()

    }
}
