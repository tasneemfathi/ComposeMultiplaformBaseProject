package org.example.project

import androidx.compose.ui.window.ComposeUIViewController
import org.example.project.di.KoinInitializer

fun MainViewController() = ComposeUIViewController (configure = {
    KoinInitializer().init() }){
    App()
}