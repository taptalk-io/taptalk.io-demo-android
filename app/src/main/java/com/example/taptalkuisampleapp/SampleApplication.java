package com.example.taptalkuisampleapp;

import android.app.Application;
import android.util.Log;
import io.taptalk.TapTalk.Helper.TapTalk;
import io.taptalk.TapTalk.Listener.TAPListener;
import io.taptalk.TapTalk.Model.TAPMessageModel;

public class SampleApplication extends Application {

    private String TAG = getClass().getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();
        TapTalk.setTapTalkEnvironmentDevelopment();
        TapTalk.init(
                this,
                "d1e5dfe23d1e00bf54bc2316f",
                "NTQzMTBjZDI5YWNjNTEuMS4x/ZDY4MTg3Yjg/OTA0MTQwNDFhMDYw/MGI0YjA5NTJjM2Fh",
                R.mipmap.ic_launcher,
                "TapTalk UI Sample Application",
                TapTalk.TapTalkImplementationType.TapTalkImplentationTypeUI,
                tapListener
        );
    }

    private TAPListener tapListener = new TAPListener() {
        @Override
        public void onRefreshAuthTicket() {
            Log.e(TAG, "onRefreshAuthTicket: " );
        }

        @Override
        public void onTapTalkUnreadChatRoomBadgeCountUpdated(int unreadCount) {
            Log.e(TAG, "onTapTalkUnreadChatRoomBadgeCountUpdated: ");
        }

        @Override
        public void onNotificationReceived(TAPMessageModel messageModel) {
            Log.e(TAG, "onNotificationReceived: " + messageModel.getUser().getName() + ": " + messageModel.getBody());
        }
    };
}
