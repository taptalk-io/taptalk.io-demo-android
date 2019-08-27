package com.example.taptalkuisampleapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import io.taptalk.TapTalk.Helper.TapTalk

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        TapTalk.checkActiveUserToShowPage(this)
    }
}
