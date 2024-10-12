package org.example.project


import androidx.compose.runtime.*
import org.example.project.navigation.NavigationHost
import org.example.project.ui.DynamicNavigationBarColor
import org.example.project.ui.DynamicStatusBarColor
import org.example.project.ui.MyAppTheme
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinContext


@Composable
@Preview
fun App() {
    MyAppTheme {
        KoinContext {
            NavigationHost()
        }
    }
}