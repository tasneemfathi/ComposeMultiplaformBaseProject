package org.example.project.ui.theme


import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


val DynamicPrimary : Color
    @Composable
    get() = if(isSystemInDarkTheme()) PrimaryDark else Primary

val DynamicOnPrimary: Color
    @Composable
    get() = if(isSystemInDarkTheme()) onPrimaryDark else onPrimary

val DynamicPrimaryContainer : Color
    @Composable
    get() = if(isSystemInDarkTheme()) PrimaryContainerDark else PrimaryContainer

val DynamicTextColor : Color
    @Composable
    get() = if(isSystemInDarkTheme()) TextColorDark else TextColor

val DynamicStatusBarColor : Color
    @Composable
    get() = if(isSystemInDarkTheme()) StatusBarColorDark else StatusBarColor

val DynamicNavigationBarColor : Color
    @Composable
    get() = if(isSystemInDarkTheme()) NavigationBarColorDark else NavigationBarColor


val DynamicHintTextColor : Color
    @Composable
    get() = if(isSystemInDarkTheme()) HintColorDark else HintColor


private  val myAppLightTheme:ColorScheme
    get() = lightColorScheme(primary = Primary, onPrimary = onPrimary, background = PrimaryContainer)

private  val myAppDarkTheme:ColorScheme
    get() = darkColorScheme(primary = PrimaryDark, onPrimary = onPrimaryDark, background = PrimaryContainerDark )

@Composable
fun MyAppTheme(content: @Composable () -> Unit){
    MaterialTheme(
        colorScheme = if (isSystemInDarkTheme()) myAppDarkTheme else myAppLightTheme,
        typography = typography,
        content = content
    )
}
