package org.example.project

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController


@Composable
actual fun PlatformColors(statusBarColor: Color, navBarColor: Color){
    val sysUiController = rememberSystemUiController()
    val isSystemDarkColor = isSystemInDarkTheme()
    SideEffect {
        sysUiController.setSystemBarsColor(color = statusBarColor , darkIcons = !isSystemDarkColor)
        sysUiController.setNavigationBarColor(color = navBarColor)
    }
}