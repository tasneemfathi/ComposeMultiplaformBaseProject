package org.example.project.ui.scence.add

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.unit.dp
import com.preat.peekaboo.image.picker.ResizeOptions
import com.preat.peekaboo.image.picker.SelectionMode
import com.preat.peekaboo.image.picker.rememberImagePickerLauncher
import com.preat.peekaboo.image.picker.toImageBitmap
import composemultiplatformlabproject.composeapp.generated.resources.Res
import composemultiplatformlabproject.composeapp.generated.resources.bio
import composemultiplatformlabproject.composeapp.generated.resources.camera_com
import composemultiplatformlabproject.composeapp.generated.resources.email
import composemultiplatformlabproject.composeapp.generated.resources.holder
import composemultiplatformlabproject.composeapp.generated.resources.name
import composemultiplatformlabproject.composeapp.generated.resources.update
import composemultiplatformlabproject.composeapp.generated.resources.users_title
import org.example.project.data.model.profile.Profile
import org.example.project.ui.core.MyAppTopBar
import org.example.project.ui.core.MyTextField
import org.example.project.ui.theme.DynamicPrimary
import org.example.project.utils.byteArrayToBase64
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddNewScreen(viewModel: AddNewViewModel, navUp:() -> Unit){
    val name by viewModel.name.collectAsState()
    val email by viewModel.email.collectAsState()
    val bio by viewModel.bio.collectAsState()
    val image by viewModel.image.collectAsState()
    val scope = rememberCoroutineScope()
    val resizeOptions = ResizeOptions(
        width = 500,
        height = 500,
        resizeThresholdBytes = 2 * 1024 * 1024L,
        compressionQuality = 0.5
    )
    val singleImagePicker = rememberImagePickerLauncher(
        selectionMode = SelectionMode.Single,
        scope = scope,
        resizeOptions = resizeOptions,
        onResult = { byteArrays ->
            byteArrays.firstOrNull()?.let {byteArray ->
                // Process the selected images' ByteArrays.
                viewModel.image.value = byteArray.toImageBitmap()
                viewModel.avatar.value = byteArrayToBase64(byteArray)
            }
        }
    )


    Scaffold (topBar = {MyAppTopBar(titleRes = Res.string.users_title, showNavIcon = true, navUp = navUp)}){
        Column (modifier = Modifier.padding(it).padding(horizontal = 20.dp), verticalArrangement = Arrangement.spacedBy(10.dp), horizontalAlignment = Alignment.CenterHorizontally){
            Spacer(modifier = Modifier.fillMaxWidth().height(10.dp))
            Box(modifier = Modifier.clickable {
                singleImagePicker.launch()
            }){
                if(image == null) {
                    Image(
                        painter = painterResource(Res.drawable.holder),
                        contentDescription = "User Image",
                        modifier = Modifier.size(130.dp).clip(CircleShape)
                    )
                }else{
                    Image(
                        bitmap = image!!,
                        contentDescription = "User Image",
                        modifier = Modifier.size(130.dp).clip(CircleShape)
                    )
                }
                Icon(painter = painterResource(Res.drawable.camera_com), contentDescription = "", tint = DynamicPrimary, modifier = Modifier.padding(3.dp).size(24.dp).align(Alignment.BottomEnd))
            }

            Spacer(modifier = Modifier.fillMaxWidth().height(10.dp))
            MyTextField(label = stringResource(Res.string.name), text = name , onValueChange = {newValue ->
                viewModel.name.value = newValue
            })
            MyTextField(label = stringResource(Res.string.email), text = email, onValueChange = {newValue ->
                viewModel.email.value = newValue
            })
            MyTextField(label = stringResource(Res.string.bio), text = bio , maxLine = 5, onValueChange = {newValue ->
                viewModel.bio.value = newValue
            })
            Spacer(modifier = Modifier.fillMaxWidth().height(10.dp))
            Button(onClick = {viewModel.updateProfile()}){
                Text(stringResource(Res.string.update))
            }
        }
    }



}