package org.example.project.ui.core

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import org.example.project.ui.theme.DynamicHintTextColor
import org.example.project.ui.theme.DynamicOnPrimary
import org.example.project.ui.theme.DynamicTextColor
import org.example.project.ui.theme.body
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun MyTextField(iconRes: DrawableResource? = null, label:String, text:String,onValueChange: (String) -> Unit, maxLine:Int = 1, keyboardType:KeyboardType = KeyboardType.Text, isMobile:Boolean = false){
    val focusRequester = remember { FocusRequester() }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .border(
                width = 1.dp,
                shape = RoundedCornerShape(size = 15.dp),
                color = Color.Gray
            )
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        iconRes?.let { Icon(painter = painterResource(iconRes), tint = Color.Unspecified, contentDescription = label, modifier = Modifier.padding(top =15.dp))  }

        TextField(
            value = text,
            onValueChange = {onValueChange(it)},
            label = { Text(text = label, style = body, color = DynamicHintTextColor) },
            modifier = Modifier
                .weight(1f)
                .focusRequester(focusRequester),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            minLines = maxLine,
            maxLines = maxLine,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = keyboardType
            )

        )
    }
}