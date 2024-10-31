package org.example.project.ui.core.components

import androidx.compose.foundation.clickable
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import composemultiplatformlabproject.composeapp.generated.resources.Res
import composemultiplatformlabproject.composeapp.generated.resources.ic_back_arrow
import org.example.project.ui.theme.DynamicPrimary
import org.jetbrains.compose.resources.painterResource

@Composable
fun NavBackIcon(navUp:() -> Unit){
    Icon(painter = painterResource( Res.drawable.ic_back_arrow), tint = DynamicPrimary, contentDescription = "Go Back" , modifier = Modifier.clickable {  navUp()} )
}