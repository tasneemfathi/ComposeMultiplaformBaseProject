package org.example.project.scence.users

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import composemultiplatformlabproject.composeapp.generated.resources.Res
import composemultiplatformlabproject.composeapp.generated.resources.for_more_info
import composemultiplatformlabproject.composeapp.generated.resources.qr_code
import composemultiplatformlabproject.composeapp.generated.resources.scan_qr
import org.example.project.data.model.user.User
import org.example.project.ui.theme.title
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun UserSheet(user: User){
    Column (modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(10.dp)){
        UserCell(modifier = Modifier,user = user)
        HorizontalDivider(modifier = Modifier.fillMaxWidth().height(20.dp))
        Text(stringResource(Res.string.for_more_info), style = title)
        Text(stringResource(Res.string.scan_qr), style = title)
        Spacer(modifier = Modifier.fillMaxWidth().height(20.dp))
        Image(painter = painterResource(Res.drawable.qr_code) , contentDescription = "QR Code")
        Spacer(modifier = Modifier.fillMaxWidth().height(50.dp))
    }

}