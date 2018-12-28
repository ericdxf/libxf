package com.common.dxf.libxf.utils;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.app.NotificationCompat;

import com.common.dxf.libxf.R;

import static android.content.Context.NOTIFICATION_SERVICE;

/**
 * @author Eric
 * @date 2018/12/24
 * @Description 通知工具类
 */
public class NotifyUtil {
    private static NotifyUtil instance;
    private NotificationManager notificationManager;
    private int notifyId;// 通知id

    public static NotifyUtil getInstance() {
        if (instance == null) {
            synchronized (NotifyUtil.class) {
                if (instance == null)
                    instance = new NotifyUtil();
            }
        }
        return instance;
    }

    public void showNotification(Context context) {
        showNotification(context, "标题", "内容", R.mipmap.ic_launcher);
    }

    public void showNotification(Context context, String title, String content) {
        showNotification(context, title, content, R.mipmap.ic_launcher);
    }

    public void showNotification(Context context, String title, String content, PendingIntent pendingIntent) {
        showNotification(context, title, content, R.mipmap.ic_launcher, pendingIntent);
    }

    /**
     * @date 2018/12/24
     * @author dxf
     * @Description 发送通知
     */
    public void showNotification(Context context, String title, String content, int icon) {
        notificationManager = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);
        Notification notification;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            int importance = NotificationManager.IMPORTANCE_HIGH;
            String packageName = context.getPackageName();
            CharSequence name = context.getString(R.string.app_name);
            // Android8.0通知需要配置channel，用来细化通知类别
            NotificationChannel mChannel = new NotificationChannel(packageName, name, importance);
            mChannel.enableLights(true);
            mChannel.setLightColor(Color.RED);
            mChannel.enableVibration(true);
            mChannel.setShowBadge(true);
            notificationManager.createNotificationChannel(mChannel);
            notification = new NotificationCompat.Builder(context, packageName)
                    .setContentTitle(title)
                    .setContentText(content)
                    .setSmallIcon(icon)
                    .setAutoCancel(true)
                    .build();
        } else {
            notification = new NotificationCompat.Builder(context, "")
                    .setContentTitle(title)
                    .setContentText(content)
                    .setSmallIcon(icon)
                    .setOngoing(true)
                    .build();
        }
        // 因为同一个id的通知会被认为是同一个通知，导致不会弹出新的，所以每次生成不同的id用以区分
        notificationManager.notify(notifyId++, notification);
    }

    /**
     * @date 2018/12/24
     * @author dxf
     * @Description 发送通知
     */
    public void showNotification(Context context, String title, String content, int icon, PendingIntent pendingIntent) {
        notificationManager = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);
        Notification notification;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            int importance = NotificationManager.IMPORTANCE_HIGH;
            String packageName = context.getPackageName();
            CharSequence name = context.getString(R.string.app_name);
            // Android8.0通知需要配置channel，用来细化通知类别
            NotificationChannel mChannel = new NotificationChannel(packageName, name, importance);
            mChannel.enableLights(true);
            mChannel.setLightColor(Color.RED);
            mChannel.enableVibration(true);
            mChannel.setShowBadge(true);
            notificationManager.createNotificationChannel(mChannel);
            notification = new NotificationCompat.Builder(context, packageName)
                    .setContentTitle(title)
                    .setContentText(content)
                    .setSmallIcon(icon)
                    .setAutoCancel(true)
                    .setContentIntent(pendingIntent)
                    .build();
        } else {
            notification = new NotificationCompat.Builder(context, "")
                    .setContentTitle(title)
                    .setContentText(content)
                    .setSmallIcon(icon)
                    .setOngoing(true)
                    .build();
        }
        // 因为同一个id的通知会被认为是同一个通知，导致不会弹出新的，所以每次生成不同的id用以区分
        notificationManager.notify(notifyId++, notification);
    }
}