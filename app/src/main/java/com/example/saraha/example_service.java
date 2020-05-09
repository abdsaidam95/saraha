package com.example.saraha;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.IBinder;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;


import com.example.saraha.views.MainActivity;

import static com.example.saraha.appnotify.channel_id;


public class example_service extends Service {
    Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {


        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();



    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String input = intent.getStringExtra("inputExtra");
        Intent notificationIntent = new Intent(this, MainActivity.class);
        Intent showIntent = new Intent(this, MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, showIntent, 0);


        Notification notification = new NotificationCompat.Builder(this, channel_id)
                .setContentTitle("Example Service")
                .setContentText(input)
                .setSmallIcon(R.drawable.ic_cloooose)
                .setDefaults(Notification.DEFAULT_ALL)
                .setContentIntent(contentIntent)
                .setAutoCancel(true)
                .setSound(defaultSoundUri)

                .build();

        notification.flags |= Notification.FLAG_AUTO_CANCEL;

        startForeground(1, notification);

        return START_NOT_STICKY;

    }

    @Override
    public void onDestroy() {


        super.onDestroy();

    }
}
