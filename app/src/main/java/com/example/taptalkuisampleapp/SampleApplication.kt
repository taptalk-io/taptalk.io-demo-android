package com.example.taptalkuisampleapp

import android.app.Application
import io.taptalk.TapTalk.Helper.TapTalk
import io.taptalk.TapTalk.Listener.TapListener
import io.taptalk.TapTalk.Model.TAPMessageModel

class SampleApplication : Application() {

    private val TAG = javaClass.simpleName

    private val tapListener = object : TapListener() {
        override fun onTapTalkRefreshTokenExpired() {
            super.onTapTalkRefreshTokenExpired()
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
            this, "ddf6fc9507a3a4f6386c3d6b8",
            "MzMzMTQ0QDUuMjMuMTEwQDE1Njg4MjIzMTk/OWRjYmU2YzI/NGIyMjQyMzdiMzIy/MmYwODE4NWU0Nzc2",
            R.mipmap.ic_launcher, "TapTalk Dev Sample App",
            "https://e-dev-43588589a565102ffa8d6a92bff6b4f4.io.taptalk.io",
            TapTalk.TapTalkImplementationType.TapTalkImplementationTypeUI,
            tapListener
        )
        TapTalk.initializeGooglePlacesApiKey("AIzaSyA1kCb7yq2shvC3BnzriJLcTfzQdmzSnPA")
    }
}
