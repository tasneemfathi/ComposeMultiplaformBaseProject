package org.example.project


import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import coil3.compose.setSingletonImageLoaderFactory
import org.example.project.navigation.NavigationHost
import org.example.project.ui.theme.DynamicNavigationBarColor
import org.example.project.ui.theme.DynamicStatusBarColor
import org.example.project.ui.theme.MyAppTheme
import org.example.project.utils.getAsyncImageLoader
import org.example.project.utils.isAppLangAr
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinContext
import org.koin.compose.viewmodel.koinViewModel


@Composable
@Preview
fun App() {
    val mainViewModel = koinViewModel<AppViewModel>()
    val appCurrentLanguage   = mainViewModel.appLang.collectAsState(initial = "ar")
    PlatformColors(DynamicStatusBarColor, DynamicNavigationBarColor)
    CompositionLocalProvider(LocalLayoutDirection provides  if(isAppLangAr(appCurrentLanguage.value)) LayoutDirection.Rtl else LayoutDirection.Ltr) {
        MyAppTheme {
            setSingletonImageLoaderFactory { context ->
                getAsyncImageLoader(context)
            }
            KoinContext {
                NavigationHost()
            }
        }

    }
}

