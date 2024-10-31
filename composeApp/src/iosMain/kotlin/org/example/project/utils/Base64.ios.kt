package org.example.project.utils

import androidx.compose.ui.graphics.ImageBitmap
import io.ktor.util.decodeBase64Bytes
import org.jetbrains.skia.Image
import androidx.compose.ui.graphics.toComposeImageBitmap
import platform.CoreGraphics.CGSize
import platform.UIKit.UIImage

actual fun decodeBase64ToImageBitmap(base64: String): ImageBitmap? {
    return Image.makeFromEncoded(base64.decodeBase64Bytes()).toComposeImageBitmap()
}

