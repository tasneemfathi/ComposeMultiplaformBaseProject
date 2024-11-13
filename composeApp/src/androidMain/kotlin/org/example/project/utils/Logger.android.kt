package org.example.project.utils

import android.util.Log

actual fun log(msg: String) {
    Log.d("MyApp", msg)
}