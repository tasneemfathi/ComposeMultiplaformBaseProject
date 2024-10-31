package org.example.project.ui.core

import androidx.compose.foundation.Image
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import coil3.compose.SubcomposeAsyncImage
import composemultiplatformlabproject.composeapp.generated.resources.Res
import composemultiplatformlabproject.composeapp.generated.resources.holder
import org.jetbrains.compose.resources.painterResource

@Composable
fun MyAsyncImage(modifier: Modifier, url:String, contentDescription:String = "Image description"){
    SubcomposeAsyncImage(
        modifier = modifier,
        model = url,
        contentDescription = contentDescription,
        loading = {
            CircularProgressIndicator() // Shows a loading indicator
        },
        error = {
          Image(painter = painterResource(Res.drawable.holder),contentDescription = "Holder Image")// Shows an error message
        }
    )
}