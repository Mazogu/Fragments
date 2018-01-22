package com.example.micha.funwithfragments;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class NotificationActivity extends AppCompatActivity {

    private NotificationManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        String id = "channel_id5";
    }

    public void notify(View view) {
        Notification.Builder builder = new Notification.Builder(this);
        builder.setContentTitle("A Notification");
        builder.setContentText("It's just a notification");
        builder.setSmallIcon(R.drawable.mini_skeith3rd);
        builder.setPriority(Notification.PRIORITY_MAX);
        Intent intent = new Intent(this, PDFActivity.class);
        TaskStackBuilder stack = TaskStackBuilder.create(this);
        stack.addNextIntent(intent);
        PendingIntent pending = stack.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pending);
        manager.notify(1,builder.build());
    }
}
