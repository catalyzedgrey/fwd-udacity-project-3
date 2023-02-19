package com.udacity

import android.app.DownloadManager
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import androidx.core.app.NotificationCompat


private val NOTIFICATION_ID = 0

fun NotificationManager.sendNotification(messageBody: String, context: Context) {
    val contentIntent = Intent(context, DetailActivity::class.java)

    contentIntent.putExtra(
        context.getString(R.string.status),
        "Success!"
    )

    val contentPendingIntent = PendingIntent.getActivity(
        context,
        NOTIFICATION_ID,
        contentIntent,
        PendingIntent.FLAG_IMMUTABLE
    )

    val builder = NotificationCompat.Builder(
        context,
        context.getString(R.string.notification_channel_id)
    ).setSmallIcon(R.drawable.ic_launcher_foreground)
        .setContentTitle(context.getString(R.string.notification_title))
        .setContentText(messageBody)
        .setContentIntent(contentPendingIntent)
        .setAutoCancel(true)
        .addAction(
            R.drawable.ic_launcher_foreground,
            context.getString(R.string.navigate),
            contentPendingIntent
        )
        .setPriority(NotificationCompat.PRIORITY_HIGH)

    notify(NOTIFICATION_ID, builder.build())
}

fun NotificationManager.cancelNotification() {
    cancelAll()
}