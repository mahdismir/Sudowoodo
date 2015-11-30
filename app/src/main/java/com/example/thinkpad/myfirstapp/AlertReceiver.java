package com.example.thinkpad.myfirstapp;


import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

/**
 * Created by Saif on 11/23/2015.
 */
public class AlertReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent ){

        String message = "Hellooo, alrm worked ----";
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();

        createNotification(context, "DU HELLOOOOOOO", "5 seconds has passed", "Alert");
    }

    public void createNotification(Context context, String msg, String msgText, String msgAlert){
        PendingIntent notificIntent = PendingIntent.getActivity(context, 0, new Intent(context, MainActivity.class), 0);
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context)
                .setSmallIcon(R.drawable.icon_29)
                .setContentTitle(msg)
                .setContentText(msgText)
                .setTicker(msgAlert);



        mBuilder.setContentIntent(notificIntent);



        mBuilder.setDefaults(NotificationCompat.DEFAULT_SOUND);

        mBuilder.setAutoCancel(true);

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(1, mBuilder.build());


    }

}
