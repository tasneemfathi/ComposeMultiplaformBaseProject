package org.example.project


import androidx.compose.runtime.*
import org.example.project.ui.DynamicNavigationBarColor
import org.example.project.ui.DynamicStatusBarColor
import org.example.project.ui.MyAppTheme
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
@Preview
fun App() {
    MyAppTheme {
        AppMain()
    }
}