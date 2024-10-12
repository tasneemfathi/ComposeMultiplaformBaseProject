package org.example.project

import android.app.Application
import org.example.project.di.KoinInitializer


class BaseApp: Application() {

    override fun onCreate() {
        super.onCreate()
        KoinInitializer(applicationContext).init()
    }
}