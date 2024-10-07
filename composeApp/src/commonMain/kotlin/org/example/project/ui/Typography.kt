package org.example.project.ui


import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import composemultiplatformlabproject.composeapp.generated.resources.Res
import composemultiplatformlabproject.composeapp.generated.resources.bold
import composemultiplatformlabproject.composeapp.generated.resources.medium
import composemultiplatformlabproject.composeapp.generated.resources.regular
import composemultiplatformlabproject.composeapp.generated.resources.semibold
import org.jetbrains.compose.resources.Font

val MyAppFontFamily : FontFamily
    @Composable
    get() = FontFamily(
    Font(Res.font.regular, weight = FontWeight.Normal),
    Font(Res.font.medium, weight = FontWeight.Medium),
    Font(Res.font.bold, weight = FontWeight.Bold),
    Font(Res.font.semibold, weight = FontWeight.SemiBold),
)

val title :TextStyle
    @Composable
    get()= TextStyle(
    fontFamily = MyAppFontFamily,
    fontWeight = FontWeight.Bold,
    fontSize = 20.sp,
    color = DynamicTextColor
)
val subtitle :TextStyle
    @Composable
    get()= TextStyle(
    fontFamily = MyAppFontFamily,
    fontWeight = FontWeight.Bold,
    fontSize = 16.sp,
     color = DynamicTextColor,
)
val bodyMedium :TextStyle
    @Composable
    get() = TextStyle(
    fontFamily = MyAppFontFamily,
    fontWeight = FontWeight.Medium,
    fontSize = 14.sp,
    color = DynamicTextColor,
    lineHeight = 20.sp
    )

val body :TextStyle
@Composable
    get() = TextStyle(
    fontFamily = MyAppFontFamily,
    fontWeight = FontWeight.Normal,
    fontSize = 12.sp,
    color = DynamicTextColor,
    lineHeight = 20.sp
    )

val typography  :Typography
    @Composable
    get() = Typography(
    titleLarge = title,
    headlineLarge = subtitle,
    bodyMedium = bodyMedium,
    bodySmall = body
)

