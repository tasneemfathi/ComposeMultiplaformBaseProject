package org.example.project.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State


expect fun changeAppLocaleToEnglish()
expect fun changeAppLocaleToArabic()

fun switchAppLang(
    currentAppLang: State<String>,
    updateAppLang:(String) -> Unit
) {
    if (currentAppLang.value.lowercase() == "ar") {
        updateAppLang("en")
        changeAppLocaleToEnglish()
    } else {
        updateAppLang("ar")
        changeAppLocaleToArabic()
    }
}

fun isAppLangAr(currentLang:String):Boolean{
    return currentLang.lowercase() == "ar"
}