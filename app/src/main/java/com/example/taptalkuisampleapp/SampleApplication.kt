package com.example.taptalkuisampleapp

import android.app.Application
import android.content.Intent
import io.taptalk.TapTalk.Helper.TapTalk
import io.taptalk.TapTalk.Listener.TapListener
import io.taptalk.TapTalk.Model.TAPMessageModel

class SampleApplication : Application() {

    private val TAG = javaClass.simpleName

    private val tapListener = object : TapListener() {
        override fun onTapTalkRefreshTokenExpired() {
            super.onTapTalkRefreshTokenExpired()
            val intent = Intent(applicationContext, TAPLoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            applicationContext.startActivity(intent)
        }

        override fun onTapTalkUnreadChatRoomBadgeCountUpdated(i: Int) {
            super.onTapTalkUnreadChatRoomBadgeCountUpdated(i)
        }

        override fun onNotificationReceived(tapMessageModel: TAPMessageModel?) {
            super.onNotificationReceived(tapMessageModel)
            TapTalk.showTaptalkNotification(tapMessageModel)
        }

        override fun onUserLogout() {
            super.onUserLogout()
        }
    }

    override fun onCreate() {
        super.onCreate()
        TapTalk.setLoggingEnabled(true)
        TapTalk.init(
            this, "APP_KEY_ID",
            "APP_KEY_SECRET",
            R.mipmap.ic_launcher, "TapTalk Dev Sample App",
            "API_BASE_URL",
            TapTalk.TapTalkImplementationType.TapTalkImplementationTypeUI,
            tapListener
        )
        TapTalk.initializeGooglePlacesApiKey("GOOGLE_PLACES_API_KEY")
    }
}
