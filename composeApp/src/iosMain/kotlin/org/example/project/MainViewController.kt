package org.example.project

import androidx.compose.ui.window.ComposeUIViewController
import org.example.project.di.KoinInitializer
import org.example.project.utils.changeAppLocaleToArabic
import org.example.project.utils.changeAppLocaleToEnglish
import platform.UIKit.UIViewController
import platform.darwin.NSObject

fun MainViewController() = ComposeUIViewController (configure = {
    KoinInitializer().init() }){
    App()
}

