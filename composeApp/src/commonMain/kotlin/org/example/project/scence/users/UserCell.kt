package org.example.project.scence.users

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import composemultiplatformlabproject.composeapp.generated.resources.Res
import composemultiplatformlabproject.composeapp.generated.resources.welcome_static_text
import org.example.project.data.model.user.User
import org.example.project.ui.core.MyAsyncImage
import org.example.project.ui.theme.body
import org.example.project.ui.theme.subtitle
import org.jetbrains.compose.resources.stringResource

@Composable
fun UserCell(modifier: Modifier,user: User){
    Row(modifier = modifier.fillMaxWidth().height(100.dp).padding(horizontal = 20.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(20.dp)){
        MyAsyncImage(Modifier.size(size = 60.dp).clip(CircleShape), url = user.avatar, contentDescription = "User Avatar")

        Column (modifier = Modifier.weight(1f).wrapContentHeight(), verticalArrangement = Arrangement.spacedBy(6.dp)){
            Text(text = user.firstName +" "+ user.lastName, style = subtitle)
            Text(text = user.email, style = body , color = Color.DarkGray)
            Text(text = stringResource(Res.string.welcome_static_text), style = body , color = Color.DarkGray)
        }
    }
}