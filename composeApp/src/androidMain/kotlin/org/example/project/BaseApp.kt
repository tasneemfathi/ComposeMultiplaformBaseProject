package org.example.project

import android.app.Application
import com.mmk.kmpnotifier.notification.NotifierManager
import com.mmk.kmpnotifier.notification.configuration.NotificationPlatformConfiguration
import org.example.project.di.KoinInitializer


class BaseApp: Application() {

    override fun onCreate() {
        super.onCreate()
        KoinInitializer(applicationContext).init()
        NotifierManager.initialize(
            configuration = NotificationPlatformConfiguration.Android(
                notificationIconResId = R.drawable.ic_launcher_foreground,
                showPushNotification = true,
            )
        )
    }
}