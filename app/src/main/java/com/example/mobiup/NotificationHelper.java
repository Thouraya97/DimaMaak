package com.example.mobiup;

import android.annotation.TargetApi;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;

import androidx.core.app.NotificationCompat;

class NotificationHelper extends ContextWrapper {
    // Uri soundUri = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE + "://"+ getApplicationContext().getPackageName() + "/" + R.raw.sahtek);
    //Uri uri = Uri.parse("android.resource://" + getApplicationContext().getPackageName() + "/" + R.raw.sahtek);
    public static final String channelID = "channelID";
    public static final String channelName = "Channel Name";
    private static final int NOTIFICATION_ID = 0;
    private NotificationManager mManager;

    public NotificationHelper(Context base) {
        super(base);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createChannel();
        }
    }

    @TargetApi(Build.VERSION_CODES.O)
    private void createChannel() {
        NotificationChannel channel = new NotificationChannel(channelID, channelName, NotificationManager.IMPORTANCE_HIGH);

        getManager().createNotificationChannel(channel);
    }

    public NotificationManager getManager() {
        if (mManager == null) {
            mManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        }

        return mManager;
    }

    public NotificationCompat.Builder getChannelNotification() {
       // Uri sound = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.sahtek);
        Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent notificationPendingIntent = PendingIntent.getActivity
                (this,NOTIFICATION_ID, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);


        return new NotificationCompat.Builder(getApplicationContext(), channelID)
                .setContentIntent(notificationPendingIntent)
                .setContentTitle("Alarm!")

                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentText("rod belek");
        //.setSound(sound);



    }
}
