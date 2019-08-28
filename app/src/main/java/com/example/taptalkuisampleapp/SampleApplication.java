package com.example.taptalkuisampleapp;

import android.app.Application;
import android.util.Log;

import io.taptalk.TapTalk.Helper.TapTalk;
import io.taptalk.TapTalk.Listener.TapListener;
import io.taptalk.TapTalk.Model.TAPMessageModel;

public class SampleApplication extends Application {

    private String TAG = getClass().getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();
        TapTalk.init(this, "d1e5dfe23d1e00bf54bc2316f",
                "NTQzMTBjZDI5YWNjNTEuMS4x/ZDY4MTg3Yjg/OTA0MTQwNDFhMDYw/MGI0YjA5NTJjM2Fh",
                //R.mipmap.ic_launcher, getResources().getString(R.string.tap_app_name),
                R.mipmap.ic_launcher, "TapTalk Dev Sample App", "engine-dev.taptalk.io",
                TapTalk.TapTalkImplementationType.TapTalkImplementationTypeUI,
                tapListener);
        TapTalk.initializeGooglePlacesApiKey("AIzaSyA1kCb7yq2shvC3BnzriJLcTfzQdmzSnPA");
    }

    private TapListener tapListener = new TapListener() {
        @Override
        public void onTapTalkRefreshTokenExpired() {
            super.onTapTalkRefreshTokenExpired();
            Log.e(TAG, "onTapTalkRefreshTokenExpired: ");
        }

        @Override
        public void onTapTalkUnreadChatRoomBadgeCountUpdated(int i) {
            super.onTapTalkUnreadChatRoomBadgeCountUpdated(i);
            Log.e(TAG, "onTapTalkUnreadChatRoomBadgeCountUpdated: ");
        }

        @Override
        public void onNotificationReceived(TAPMessageModel tapMessageModel) {
            super.onNotificationReceived(tapMessageModel);
            Log.e(TAG, "onNotificationReceived: ");
        }
    };
}
