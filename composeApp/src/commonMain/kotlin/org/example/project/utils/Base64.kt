package org.example.project.utils

import androidx.compose.ui.graphics.ImageBitmap
import coil3.Bitmap
import kotlinx.coroutines.CoroutineStart
import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi

// Common code to convert ByteArray to Base64 String
@OptIn(ExperimentalEncodingApi::class)
fun byteArrayToBase64(byteArray: ByteArray): String {
    return Base64.encode(byteArray)
}


expect fun decodeBase64ToImageBitmap(base64: String): ImageBitmap?
