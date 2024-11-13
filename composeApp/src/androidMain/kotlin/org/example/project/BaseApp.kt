package org.example.project

import android.app.Application
import android.content.Context
import com.mmk.kmpnotifier.notification.NotifierManager
import com.mmk.kmpnotifier.notification.configuration.NotificationPlatformConfiguration
import org.example.project.di.KoinInitializer


class BaseApp: Application() {
    companion object {
        lateinit var instance: BaseApp
            private set

        fun getAppContext(): Context = instance.applicationContext
    }
    override fun onCreate() {
        super.onCreate()
        instance = this
        KoinInitializer(applicationContext).init()
        NotifierManager.initialize(
            configuration = NotificationPlatformConfiguration.Android(
                notificationIconResId = R.drawable.ic_launcher_foreground,
                showPushNotification = true,
            )
        )
    }
}