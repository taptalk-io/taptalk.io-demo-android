package com.example.taptalkuisampleapp

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import io.taptalk.TapTalk.Helper.TapTalk
import io.taptalk.TapTalk.Manager.TAPDataManager
import io.taptalk.TapTalk.View.Activity.TAPLoginActivity
import io.taptalk.TapTalk.View.Activity.TAPRoomListActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent: Intent
        if (TAPDataManager.getInstance().checkAccessTokenAvailable()!!) {
            intent = Intent(this@MainActivity, TAPRoomListActivity::class.java)
        } else {
            intent = Intent(this@MainActivity, TAPLoginActivity::class.java)
        }
        startActivity(intent)
        finish()

    }
}
