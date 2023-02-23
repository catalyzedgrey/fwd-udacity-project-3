package com.udacity

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat


private val NOTIFICATION_ID = 0

fun NotificationManager.sendNotification(
    messageBody: String,
    status: String,
    fileName: String,
    context: Context
) {
    val contentIntent = Intent(context, DetailActivity::class.java)

    contentIntent.putExtra(
        context.getString(R.string.status),
        status
    )

    contentIntent.putExtra(
        context.getString(R.string.filename),
        fileName
    )

    contentIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or
            Intent.FLAG_ACTIVITY_SINGLE_TOP

    val contentPendingIntent = PendingIntent.getActivity(
        context,
        NOTIFICATION_ID,
        contentIntent,
        PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_ONE_SHOT
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