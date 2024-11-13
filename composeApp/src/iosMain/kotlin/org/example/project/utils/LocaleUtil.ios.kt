package org.example.project.utils


import platform.Foundation.NSUserDefaults



actual fun changeAppLocaleToEnglish() {
    //  changeLocaleToEnglish()
    NSUserDefaults.standardUserDefaults.setObject(arrayListOf("en"),"AppleLanguages")
}

actual fun changeAppLocaleToArabic() {
    // changeLocaleToArabic()
    NSUserDefaults.standardUserDefaults.setObject(arrayListOf("ar"),"AppleLanguages")
}
