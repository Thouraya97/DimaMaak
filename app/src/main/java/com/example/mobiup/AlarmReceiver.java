package com.example.mobiup;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Vibrator;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;

        public  class AlarmReceiver extends BroadcastReceiver {
    private MediaPlayer mediaPlayer;


    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Time Up... Now Vibrating !!!",
                Toast.LENGTH_LONG).show();
        Vibrator vibrator = (Vibrator) context
                .getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(2000);
        mediaPlayer = MediaPlayer.create(context, R.raw.sahtek);
        mediaPlayer.start();
        mediaPlayer.setLooping(false);
        //set looping true to run it infinitely
        //context.startService(new Intent(context, AlarmSoundService.class));
        NotificationHelper notificationHelper = new NotificationHelper(context);
        NotificationCompat.Builder nb = notificationHelper.getChannelNotification();
        notificationHelper.getManager().notify(1, nb.build());
        Intent i = new Intent().setClass(context,AlarmActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
        context.startActivity(i);

    }
}
